package com.shop.dao;

import com.shop.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/26.
 */
public interface GoodsDao {
    /**
     * 获取热门商品
     * @param productCategoryId
     * @param hotId
     * @return
     */
    @Select("SELECT  " +
            " g.id, g.`name`, g.caption, g.price, g.image  " +
            "FROM  " +
            " xx_goods g  " +
            "LEFT JOIN xx_product_category p ON g.product_category = p.id  " +
            "LEFT JOIN xx_goods_tag t ON g.id = t.goods  " +
            "WHERE  " +
            " p.tree_path LIKE ',${productCategoryId},%'  " +
            "AND t.tags = #{hotId}  " +
            "AND g.is_marketable = 1  " +
            "ORDER BY  " +
            " g.id  " +
            "LIMIT 10")
    List<GoodsVo> findHotGoods(@Param(value = "productCategoryId") Integer productCategoryId,
                               @Param(value = "hotId") Integer hotId);
}
