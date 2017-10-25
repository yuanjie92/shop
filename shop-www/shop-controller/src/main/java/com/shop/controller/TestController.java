package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuanjie on 2017/10/23.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    public String index(Model model,String name){
        model.addAttribute("hello","first test");
        model.addAttribute("name",name);
        return "test";
    }

    @RequestMapping("find/{id}")
    @ResponseBody
    public Integer findById(@PathVariable Integer id){
        return 1;
    }
}
