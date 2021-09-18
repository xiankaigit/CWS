package com.xk.bigdata.cws.common.beans.dto;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/18 下午7:51
 */
public class SqlValidateError extends RuntimeException {
    public SqlValidateError() {
    }

    public SqlValidateError(String message) {
        super(message);
    }
}
