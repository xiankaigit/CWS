package com.xk.bigdata.cws.common.beans.bo;

import java.io.Serializable;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午10:25
 */
public class ItBO implements Serializable {

    private Integer id;
    private String kind;
    private String name;
    private Integer userId;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
