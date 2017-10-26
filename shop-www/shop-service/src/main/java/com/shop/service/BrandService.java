package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.BrandDao;
import com.shop.exception.ParamException;
import com.shop.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/25.
 */
@Service
public class BrandService {
    @Autowired
    private BrandDao brandDao;

    public List<Brand> findProductCategoryBrands(Integer productCategoryId,Integer limit) {
        List<Brand> bands = null;
        if(limit == null){
            limit = Constant.FOUR;
        }
        if(productCategoryId == null ){
            bands = brandDao.findBrands(limit);
        }else{
            bands = brandDao.findProductCategoryBrands(productCategoryId,limit);
        }
        return bands;
    }
}
