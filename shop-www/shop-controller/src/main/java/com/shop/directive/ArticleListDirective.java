package com.shop.directive;

import com.shop.model.Article;
import com.shop.service.AritcleService;
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
public class ArticleListDirective extends BaseDirective {
    @Autowired
    private AritcleService aritcleService;
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        //获取参数
        Integer categoryId = getParameter(params,"categoryId",Integer.class);
        Integer count = getParameter(params,"count",Integer.class);
        //获取结果
        List<Article> articles = aritcleService.findList(categoryId,count);
        //输出
        setVariable(env,body,"articles",articles);
    }
}
