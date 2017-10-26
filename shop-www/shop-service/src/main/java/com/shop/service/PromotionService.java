package com.shop.service;

import com.shop.dao.PromotionDao;
import com.shop.exception.ParamException;
import com.shop.model.Promotion;
import org.apache.ibatis.builder.ParameterExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/25.
 */
@Service
public class PromotionService {
    @Autowired
    private PromotionDao promotionDao;

    public List<Promotion> findProductCategoryPromotions(Integer productCategoryId) {
        if(productCategoryId == null || productCategoryId < 1){
            throw new ParamException("请选择分类");
        }
        List<Promotion> promotions = promotionDao.findProductCategoryPromotions(productCategoryId);
        return promotions;
    }
}
