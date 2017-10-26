package com.shop.directive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanjie on 2017/10/24.
 */
@Component
public class HelloDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        System.out.println("输出参数:"+map);
        //获取参数，需要用到BeansWrapper进行类型的转换
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel nameModel = (TemplateModel) map.get("name");
        String name = (String) beansWrapper.unwrap(nameModel,String.class);
        //构建返回结果
        Map<String,String> result = new HashMap<String,String>();
        result.put("test","only test");
        result.put("userName",name);
        //把结果存放env里面,有需要将java对象转化为数据模型
        environment.setVariable("helloworld", (beansWrapper.wrap(result)) );
        //输出
        Writer out = environment.getOut();
        if(templateDirectiveBody != null){
            templateDirectiveBody.render(out);
        }else{
            out.write(JSON.toJSONString(result));
        }
    }
}
