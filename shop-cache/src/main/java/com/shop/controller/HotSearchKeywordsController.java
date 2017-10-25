package com.shop.controller;

import com.shop.base.ResultInfo;
import com.shop.service.HotSearchKeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yuanjie on 2017/10/24.
 */

@RestController
@RequestMapping("hot_search_keyword")
public class HotSearchKeywordsController {
    @Autowired
    private HotSearchKeywordsService hotSearchKeywordsService;

    @GetMapping("get")
    public ResultInfo findHotSearchKeywords(){
        List<String> hotkeywords = hotSearchKeywordsService.find();
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(hotkeywords);
        resultInfo.setResultCode(1);
        resultInfo.setResultMessage("查询成功");
        return resultInfo;
    }

   @PostMapping("set")
    public ResultInfo addHotSearchKeywords(String keywords){
        Long result = hotSearchKeywordsService.set(keywords);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(result);
        resultInfo.setResultCode(1);
        resultInfo.setResultMessage("添加成功");
        return resultInfo;
   }

}
