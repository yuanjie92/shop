package com.shop.dao;

import com.shop.model.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/26.
 */
public interface ArticleDao {
    @Select("select id, title from xx_article where article_category = #{categoryId} " +
            "and is_publication = 1 order by id limit #{count}")
    List<Article> findList(@Param(value = "categoryId") Integer categoryId,
                           @Param(value = "count") Integer count);
}
