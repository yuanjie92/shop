package com.shop.exception;

import com.shop.constant.Constant;

/**
 * Created by yuanjie on 2017/10/25.
 */
public class ParamException extends RuntimeException {
    private Integer errorCode;

    public ParamException() {
        super(Constant.ERROR_MSG);
        this.errorCode = Constant.ERROR_CODE;
    }

    public ParamException( Integer errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ParamException(String message) {
        super(message);
        this.errorCode = Constant.ERROR_CODE;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
