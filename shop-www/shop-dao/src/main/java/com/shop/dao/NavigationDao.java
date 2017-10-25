package com.shop.dao;

import com.shop.model.Navigation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/24.
 */
public interface NavigationDao {

    @Select("select id, is_blank_target, name, url from xx_navigation where " +
            "position=#{position} order by orders")
    List<Navigation> findByPosition(int position);
}
