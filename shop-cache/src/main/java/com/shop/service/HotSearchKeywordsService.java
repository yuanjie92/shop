package com.shop.service;

import com.shop.base.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class HotSearchKeywordsService {
    @Autowired
    private RedisTemplate redisTemplate;

    //从redis中读取热门搜索关键字
    public List<String> find() {
        BoundListOperations operations = redisTemplate.boundListOps("hot_search_keywords");
        List<String> result = operations.range(0,operations.size());
        return result;
    }
    //把热门搜索的关键字存入redis
    public Long set(String keywords) {
        BoundListOperations operations = redisTemplate.boundListOps("hot_search_keywords");
        String[] keyWordsArr = keywords.split(",");
        // 写入值
        Long result = operations.rightPushAll(keyWordsArr);
        return result;
    }
}
