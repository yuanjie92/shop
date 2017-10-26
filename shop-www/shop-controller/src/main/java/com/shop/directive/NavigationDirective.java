package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanjie on 2017/10/25.
 */
@Component
public class NavigationDirective extends BaseDirective{

    @Autowired
    private NavigationService navigationService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        // 获取参数
        Integer position = getParameter(params,"position",Integer.class);
        if(position == null){
            position = 0;
        }
        // 构建结果
        List<Navigation> navigationList = navigationService.findByPosition(position);
        // 输出
        setVariable(env,body,"navigations",navigationList);
    }
}
