package com.xk.bigdata.cws.common.tools.validate;

/**
 * @Description:      自动参数校验
 * @Author:          xiankai
 * @CreateDate:      2019/6/3 19:24
 */
public class ValidateParamException extends RuntimeException {

    public ValidateParamException() {
    }

    public ValidateParamException(String msg) {
        super(msg);
    }
}
