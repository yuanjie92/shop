package com.shop.service;

import com.shop.dao.AritcleCategoryDao;
import com.shop.model.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/26.
 */
@Service
public class ArticleCategoryService {
    @Autowired
    private AritcleCategoryDao aritcleCategoryDao;

    public List<ArticleCategory> findList(Integer limit) {
        List<ArticleCategory> articleCategories = aritcleCategoryDao.findList(limit);
        return articleCategories;
    }
}
