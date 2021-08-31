package com.xk.bigdata.cws.common.beans.dto.req;

import java.io.Serializable;

/**
 * The Class BaseReqDTO.
 */
public class BaseReqDTO<T extends ParamValidateAble> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
