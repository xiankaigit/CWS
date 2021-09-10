package com.xk.bigdata.cws.common.tools.exception;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 上午10:32
 */
public abstract class AbsCwsException extends RuntimeException {

    private int code;

    public AbsCwsException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
    }

    public AbsCwsException(String msg, ErrorCodeEnum errorCodeEnum) {
        super(msg);
        this.code = errorCodeEnum.getCode();
    }

    public AbsCwsException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getMsg(), cause);
        this.code = errorCodeEnum.getCode();
    }

    public AbsCwsException(String msg, ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(msg, cause);
        this.code = errorCodeEnum.getCode();
    }

    public AbsCwsException(ErrorCodeEnum errorCodeEnum, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(errorCodeEnum.getMsg(), cause, enableSuppression, writableStackTrace);
        this.code = errorCodeEnum.getCode();
    }


    public AbsCwsException(String msg, ErrorCodeEnum errorCodeEnum, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.code = errorCodeEnum.getCode();
    }
}
