package com.xk.bigdata.cws.common.beans.exception;


/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 上午10:37
 */
public class SqlParseExeception extends CwsException {

    private static final ErrorCodeEnum SQL_PARSE_EXE = ErrorCodeEnum.SQL_PARSE_EXE;

    public SqlParseExeception() {
        super(SQL_PARSE_EXE);
    }

    public SqlParseExeception(String msg) {
        super(msg,SQL_PARSE_EXE);
    }

    public SqlParseExeception(Throwable cause) {
        super(ErrorCodeEnum.SQL_PARSE_EXE, cause);
    }

    public SqlParseExeception(String msg, Throwable cause) {
        super(msg, ErrorCodeEnum.SQL_PARSE_EXE, cause);
    }


}
