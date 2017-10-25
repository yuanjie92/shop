package com.shop.service;

import com.shop.model.Navigation;
import com.shop.dao.NavigationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/24.
 */
@Service
public class NavigationService {
    @Autowired
    private NavigationDao navigationDao;

    public List<Navigation> findByPosition(int position) {
        List<Navigation> navigations = navigationDao.findByPosition(position);
        return navigations;
    }
}
