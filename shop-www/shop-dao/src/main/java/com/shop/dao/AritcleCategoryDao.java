package com.shop.dao;

import com.shop.model.ArticleCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/26.
 */
public interface AritcleCategoryDao {
    @Select("select id, name from xx_article_category where grade=0 order by orders limit #{count}")
    List<ArticleCategory> findList(@Param(value="count") Integer limit);
}
