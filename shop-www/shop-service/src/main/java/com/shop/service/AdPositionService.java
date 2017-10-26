package com.shop.service;

import com.shop.dao.AdPositionDao;
import com.shop.exception.ParamException;
import com.shop.model.AdPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuanjie on 2017/10/25.
 */
@Service
public class AdPositionService {
    @Autowired
    private AdPositionDao adPostionDao;

    public AdPosition findById(Integer id) {
        if (id == null || id < 1) {
            throw new ParamException("请选择广告位");
        }
        AdPosition adPosition = adPostionDao.findById(id);
        return adPosition;
    }
}
