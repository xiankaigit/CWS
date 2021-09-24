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
    @Column(name = "id")//数据库字段名
    //@SequenceGenerator(name = "it_conf_group", sequenceName = "seq_it_conf_group", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_it_conf_group")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String value;
    @NotNull
    private Integer itId;
    private String remark;

    public ItConfDO() {
    }

    public ItConfDO(Integer id, String name, String value, Integer itId, String remark) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.itId = itId;
        this.remark = remark;
    }

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
