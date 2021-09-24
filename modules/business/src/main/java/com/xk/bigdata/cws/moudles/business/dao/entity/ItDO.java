package com.xk.bigdata.cws.moudles.business.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @author ：xiankai
 * @date ：Created in 2021/9/21 下午9:11
 */
@Entity
@Table(name = "interpreter")
public class ItDO implements Serializable {
    @Id    //主键id
    @Column(name = "id")//数据库字段名
    //@SequenceGenerator(name = "it_group", sequenceName = "seq_it_group", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_it_group")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String kind;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private Integer userId;

    private String remark;

    public ItDO() {
    }

    public ItDO(String kind, String name, Integer userId, String remark) {
        this.kind = kind;
        this.name = name;
        this.userId = userId;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
