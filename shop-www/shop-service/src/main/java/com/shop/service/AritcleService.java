package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.ArticleDao;
import com.shop.exception.ParamException;
import com.shop.model.Article;
import org.apache.ibatis.builder.ParameterExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/26.
 */
@Service
public class AritcleService {
    @Autowired
    private ArticleDao articleDao;

    public List<Article> findList(Integer categoryId, Integer limit) {
        if(categoryId == null || categoryId < 1){
            throw new ParamException("请选择分类");
        }
        if(limit == null){
            limit = Constant.TEN;
        }
        List<Article> articles = articleDao.findList(categoryId,limit);
        return articles;
    }
}
