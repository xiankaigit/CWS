package com.xk.bigdata.cws.moudles.business.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @author ：xiankai
 * @date ：Created in 2021/9/21 下午9:11
 */
@Entity
@Table(name="interpreter")
public class ItDO implements Serializable {
    @Id	//主键id
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略
    @Column(name="id")//数据库字段名
    private Long id;
    @NotNull
    private String kind;
    @NotNull
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
