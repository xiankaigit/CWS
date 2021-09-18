package com.xk.bigdata.cws.common.beans.exception;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 上午10:32
 */
public abstract class CwsException extends RuntimeException {

    private int code;

    public CwsException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
    }

    public CwsException(String msg, ErrorCodeEnum errorCodeEnum) {
        super(msg);
        this.code = errorCodeEnum.getCode();
    }

    public CwsException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getMsg(), cause);
        this.code = errorCodeEnum.getCode();
    }

    public CwsException(String msg, ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(msg, cause);
        this.code = errorCodeEnum.getCode();
    }

    public CwsException(ErrorCodeEnum errorCodeEnum, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(errorCodeEnum.getMsg(), cause, enableSuppression, writableStackTrace);
        this.code = errorCodeEnum.getCode();
    }


    public CwsException(String msg, ErrorCodeEnum errorCodeEnum, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.code = errorCodeEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
