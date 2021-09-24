package com.xk.bigdata.cws.common.beans.bo;

import java.io.Serializable;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:31
 */
public class ItConfBO implements Serializable {

    private Integer id;
    private String name;
    private String value;
    private Integer itId;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getItId() {
        return itId;
    }

    public void setItId(Integer itId) {
        this.itId = itId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
