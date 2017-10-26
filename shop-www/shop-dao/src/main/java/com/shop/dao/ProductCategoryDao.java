package com.shop.dao;

import com.shop.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/25.
 */
public interface ProductCategoryDao {
    @Select("select id, name from xx_product_category where grade = 0 order by orders limit #{limit}")
    List<ProductCategory> findRootList( @Param(value="limit") Integer limit);

    @Select("SELECT id, name FROM xx_product_category WHERE parent = #{parentId} ORDER BY orders LIMIT #{limit}")
    List<ProductCategory> findChildrenList(@Param(value="parentId") Integer paraentId,
                                           @Param(value="limit") Integer limit);
}
