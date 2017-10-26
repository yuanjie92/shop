package com.shop.dao;

import com.shop.model.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/25.
 */
public interface BrandDao {

    @Select("SELECT t1.id, t1.name FROM xx_brand t1 LEFT JOIN xx_product_category_brand t2 " +
            " on t1.id = t2.brands WHERE product_categories = #{productCategoryId} ORDER BY orders LIMIT #{limit}")
    List<Brand> findProductCategoryBrands(@Param(value="productCategoryId") Integer productCategoryId,
                                          @Param(value="limit")Integer limit);

    @Select("SELECT t1.id, t1.name, t1.logo FROM xx_brand t1 ORDER BY orders LIMIT #{limit}")
    List<Brand> findBrands(@Param(value="limit")Integer limit);
}
