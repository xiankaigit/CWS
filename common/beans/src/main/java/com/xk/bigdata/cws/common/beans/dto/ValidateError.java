package com.xk.bigdata.cws.common.beans.dto;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/18 下午7:51
 */
public class ValidateError extends RuntimeException {
    public ValidateError() {
    }

    public ValidateError(String message) {
        super(message);
    }
}
