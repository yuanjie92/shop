package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanjie on 2017/10/24.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @PutMapping("")
    public Map<String,Object> setValue(String key,String value){
        BoundValueOperations<String,String> operations = redisTemplate.boundValueOps(key);
        operations.set(value);
        Map<String,Object> result = new HashMap<>();
        result.put("resultCode",1);
        result.put("resultMessage","添加成功");
        return result;
    }

    @GetMapping("")
    public Map<String, Object> getValue(String key) {
        BoundValueOperations<String, String> operations = redisTemplate.boundValueOps(key);
        String value = operations.get();
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", 1);
        result.put("resultMessage", "获取成功");
        result.put("result", value);
        return result;
    }
}
