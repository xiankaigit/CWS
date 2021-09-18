package com.xk.bigdata.cws.common.beans.exception;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 上午10:39
 */
public enum ErrorCodeEnum {
    SQL_PARSE_EXE(1, "an exception occurred while parsing sql");

    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
