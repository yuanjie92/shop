package com.shop.dao;

import com.shop.model.AdPosition;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yuanjie on 2017/10/25.
 */
public interface AdPositionDao {
    AdPosition findById(@Param(value = "positionId") Integer id);
}
