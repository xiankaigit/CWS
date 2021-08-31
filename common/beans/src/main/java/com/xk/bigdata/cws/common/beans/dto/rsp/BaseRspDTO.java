package com.xk.bigdata.cws.common.beans.dto.rsp;

import java.io.Serializable;

/**
 * 基础返回DTO报文
 *
 * @author xulexun 2018-10-12 16:36:29 PM
 */
public class BaseRspDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编码
     */
    private Integer code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 备注
     */
    private String remark;
    /**
     * 业务数据对象
     */
    private T bigData;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public T getBigData() {
        return bigData;
    }

    public void setBigData(T bigData) {
        this.bigData = bigData;
    }


    public static class BaseRspDTOFactory {

        public static final BaseRspDTOFactory INSTANCE = new BaseRspDTOFactory();

        public <T> BaseRspDTO<T> createSuccessResponse(T bigData) {
            return createCommonResponse(bigData, 1, "success");
        }


        public <T> BaseRspDTO<T> createFailResponseWithCommonCodeAndMsg(T bigData) {
            return createCommonResponse(bigData, 0x00000002, "error");
        }

        public <T> BaseRspDTO<T> createFailResponseWithCommonCode(T bigData, String msg) {
            return createCommonResponse(bigData,0x00000002, msg);
        }


        public <T> BaseRspDTO<T> createFailResponseWithCommonMsg(T bigData, int code) {
            return createCommonResponse(bigData, code, "error");
        }

        public <T> BaseRspDTO<T> createFailResponse(T bigData, int code, String msg) {
            return createCommonResponse(bigData, code, msg);
        }


        private <T> BaseRspDTO<T> createCommonResponse(T bigData, int code, String msg) {
            BaseRspDTO<T> baseRspDTO = new BaseRspDTO<T>();
            baseRspDTO.setBigData(bigData);
            baseRspDTO.setCode(code);
            baseRspDTO.setMsg(msg);
            return baseRspDTO;
        }
    }

}
