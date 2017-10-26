package com.shop.dao;

import com.shop.model.Promotion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/25.
 */
public interface PromotionDao {

    @Select("SELECT t1.id, image, title FROM xx_promotion t1 LEFT JOIN xx_product_category_promotion t2 " +
            "on t1.id = t2.promotions WHERE product_categories = #{productCategoryId}")
    List<Promotion> findProductCategoryPromotions(@Param(value="productCategoryId") Integer productCategoryId);
}
