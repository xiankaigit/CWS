package com.xk.bigdata.cws.common.beans.exception;


/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 上午10:37
 */
public class DBExeception extends CwsException {

    private static final ErrorCodeEnum SQL_PARSE_EXE = ErrorCodeEnum.DB_OPERATE_EXE;

    public DBExeception() {
        super(SQL_PARSE_EXE);
    }

    public DBExeception(String msg) {
        super(msg,SQL_PARSE_EXE);
    }

    public DBExeception(Throwable cause) {
        super(ErrorCodeEnum.SQL_PARSE_EXE, cause);
    }

    public DBExeception(String msg, Throwable cause) {
        super(msg, ErrorCodeEnum.SQL_PARSE_EXE, cause);
    }


}
