package com.xk.bigdata.cws.interpreter.result;

import java.io.Serializable;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/24 下午2:12
 */
public class ExeRes <T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
