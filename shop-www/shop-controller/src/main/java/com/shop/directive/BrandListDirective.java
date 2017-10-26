package com.shop.directive;

import com.shop.model.Brand;
import com.shop.service.BrandService;
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
 * Created by yuanjie on 2017/10/25.
 */
@Component
public class BrandListDirective extends BaseDirective{
    @Autowired
    private BrandService brandService;
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        //获取参数
        Integer productCategoryId = getParameter(params,"productCategoryId",Integer.class);
        Integer limit = getParameter(params,"limit",Integer.class);
        //获取结果
        List<Brand> brands = brandService.findProductCategoryBrands(productCategoryId,limit);
        //输出
        setVariable(env,body,"brands",brands);
    }
}
