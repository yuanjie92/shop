package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.ProductCategoryDao;
import com.shop.exception.ParamException;
import com.shop.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/25.
 */
@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 查询根级的分类
     * @return
     */
    public List<ProductCategory> findRootList(Integer limit) {
        if(limit == null){
            limit = Constant.SIX;
        }
        List<ProductCategory> productCategories = productCategoryDao.findRootList(limit);
        return productCategories;
    }

    public List<ProductCategory> findChildrenList(Integer paraentId,Integer limit) {
        if(paraentId == null || paraentId < 1){
            throw new ParamException("请选择父级分类");
        }
        if(limit == null){
            limit = Constant.THREE;
        }
        List<ProductCategory> productCategories = productCategoryDao.findChildrenList(paraentId,limit);
        return productCategories;
    }

}
