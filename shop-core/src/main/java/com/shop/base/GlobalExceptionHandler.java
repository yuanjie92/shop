package com.shop.base;

import com.shop.constant.Constant;
import com.shop.exception.ParamException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuanjie on 2017/10/25.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理ParamException异常
     * @param exception
     * @return json
     */
    @ExceptionHandler(value=ParamException.class)
    @ResponseBody
    public ResultInfo handlerParam(ParamException exception){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultCode(exception.getErrorCode());
        resultInfo.setResult(exception.getMessage());
        resultInfo.setResultMessage(exception.getMessage());
        return resultInfo;
    }
}
