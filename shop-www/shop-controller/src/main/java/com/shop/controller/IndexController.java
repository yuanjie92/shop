package com.shop.controller;

import com.shop.base.ResultInfo;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yuanjie on 2017/10/24.
 */
@Controller
public class IndexController {
    @Autowired
    private NavigationService navigationService;

    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model){
        model.addAttribute("ctx",request.getContextPath());
        return "index";
    }


}
