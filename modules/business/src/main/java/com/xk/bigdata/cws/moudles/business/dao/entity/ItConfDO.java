package com.xk.bigdata.cws.moudles.business.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午10:10
 */
@Entity
@Table(name = "interpreter_conf")
public class ItConfDO implements Serializable {
    @Id    //主键id
    @GeneratedValue(strategy = GenerationType.AUTO)//主键生成策略
    @Column(name = "id")//数据库字段名
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String value;
    @NotNull
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getItId() {
        return itId;
    }

    public void setItId(Long itId) {
        this.itId = itId;
    }
}
