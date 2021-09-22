package com.xk.bigdata.cws.common.beans.bo;

import java.io.Serializable;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午10:25
 */
public class ItBO implements Serializable {

    private Long id;
    private String kind;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}
