package com.wzy.demo.vo;

import javax.persistence.*;

/**
 * 数据实例
 */
@Entity
@Table(name="draw_code", uniqueConstraints = {@UniqueConstraint(columnNames="code")})
public class DrawCode {

    public DrawCode() {
    }
    @Id
    @GeneratedValue
    private Integer id;

    //兑奖码
    private String code;

    //使用状态
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
