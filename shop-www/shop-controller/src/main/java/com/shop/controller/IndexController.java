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
        List<Navigation> navigations = navigationService.findByPosition(0);
        model.addAttribute("navigations",navigations);

        RestTemplate restTemplate = new RestTemplate();
        ResultInfo resultInfo = restTemplate.getForObject("http://localhost:8081/hot_search_keyword/get",ResultInfo.class);
        List<String> hotkeywords = (List<String>) resultInfo.getResult();
        model.addAttribute("hotkeywords",hotkeywords);
        return "index";
    }


}
