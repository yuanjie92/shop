package com.shop.directive;

import com.shop.model.Ad;
import com.shop.service.AdService;
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
public class AdDirective extends BaseDirective {
    @Autowired
    private AdService adService;
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        // 获取参数
        Integer positionId = getParameter(params, "id", Integer.class);

        // 获取结果
        List<Ad> adList = adService.findAds(positionId);

        // 输出结果
        setVariable(env, body, "ads", adList);
    }
}
