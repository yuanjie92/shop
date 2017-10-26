package com.shop.directive;

import com.shop.model.AdPosition;
import com.shop.service.AdPositionService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanjie on 2017/10/25.
 */
@Component
public class AdPositionDirective  extends BaseDirective {
    @Autowired
    private AdPositionService adPositionService;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        // 获取参数
        Integer postion = getParameter(params,"id",Integer.class);
        // 获取结果
        AdPosition adPosition = adPositionService.findById(postion);
        // 输出
        // 模板内容
        String templateContent  = adPosition.getTemplate();
        // 创建一个模板
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template template = new Template("adTemplate", templateContent, configuration);
        //输出
        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("adPosition",adPosition);
        template.process(dataModel,env.getOut());
    }
}
