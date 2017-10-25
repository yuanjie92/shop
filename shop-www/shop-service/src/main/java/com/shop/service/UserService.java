package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuanjie on 2017/10/23.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findById(Integer id) {
        User user = userDao.findById(id);
        return user;
    }
}
