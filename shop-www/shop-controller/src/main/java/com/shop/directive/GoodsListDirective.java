package com.shop.directive;

import com.shop.service.GoodsService;
import com.shop.vo.GoodsVo;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanjie on 2017/10/26.
 */
@Component
public class GoodsListDirective extends BaseDirective {
    @Autowired
    private GoodsService goodsService;
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        //获取参数
        Integer productCategoryId = getParameter(params,"productCategoryId",Integer.class);
        Integer hotId = getParameter(params,"hotId",Integer.class);
        //获取结果
        List<GoodsVo> goodsVoList = goodsService.findHotGoods(productCategoryId,hotId);
        // 返回值
        setVariable(env, body, "goods", goodsVoList);
    }
}
