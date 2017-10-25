package com.shop.dao;

import com.shop.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yuanjie on 2017/10/23.
 */
public interface UserDao {

    @Select("select * from xx_user where user_id=#{id}")
    User findById(@Param(value = "id") Integer id);
}
