package com.shop.service;

import com.shop.dao.GoodsDao;
import com.shop.exception.ParamException;
import com.shop.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/26.
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public List<GoodsVo> findHotGoods(Integer productCategoryId, Integer hotId) {
        if (productCategoryId == null || productCategoryId < 1) {
            throw new ParamException("请选择分类");
        }
        if (hotId == null || hotId < 1) {
            throw new ParamException("请选择标签");
        }
        List<GoodsVo> goodsVos = goodsDao.findHotGoods(productCategoryId,hotId);
        return goodsVos;
    }
}
