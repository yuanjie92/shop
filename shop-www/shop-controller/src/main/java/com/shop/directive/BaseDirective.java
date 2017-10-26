package com.shop.directive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yuanjie on 2017/10/25.
 */
public abstract class BaseDirective implements TemplateDirectiveModel {

    /**
     * 获取参数
     * @param params 所有参数
     * @param name 参数名称
     * @param clazz 返回类型
     * @param <T> 返回类型
     * @return
     * @throws TemplateModelException
     */
    protected <T>T getParameter(Map params,String name,Class<?> clazz) throws TemplateModelException {
        // 获取参数
        TemplateModel templateModel = (TemplateModel) params.get(name);
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        T value = (T) beansWrapper.unwrap(templateModel, clazz);
        return value;
    }

    /**
     * 输出
     * @param env 环境
     * @param body 模板内容
     * @param name 输出的key名称
     * @param result 输出的值
     * @throws TemplateException
     * @throws IOException
     */
    protected void setVariable(Environment env, TemplateDirectiveBody body,
                               String name, Object result) throws TemplateException, IOException {
        //输出
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        env.setVariable(name,beansWrapper.wrap(result));
        if(body != null){
            body.render(env.getOut());
        }else{
            env.getOut().write(JSON.toJSONString(result));
        }
    }
}
