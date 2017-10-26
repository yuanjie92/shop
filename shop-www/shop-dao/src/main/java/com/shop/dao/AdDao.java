package com.shop.dao;

import com.shop.model.Ad;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/26.
 */
public interface AdDao {
    @Select("select id, title, path from xx_ad where ad_position = ${positionId}")
    List<Ad> findPositionAds(@Param(value = "positionId")Integer positionId);
}
