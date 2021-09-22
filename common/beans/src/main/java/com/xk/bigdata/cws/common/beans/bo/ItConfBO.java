package com.xk.bigdata.cws.common.beans.bo;

import java.io.Serializable;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:31
 */
public class ItConfBO implements Serializable {

    private Long id;
    private String name;
    private String value;
    private Long itId;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getItId() {
        return itId;
    }

    public void setItId(Long itId) {
        this.itId = itId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
