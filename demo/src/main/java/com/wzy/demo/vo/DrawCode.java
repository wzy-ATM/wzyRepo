package com.wzy.demo.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 数据实例
 */
@Entity
public class DrawCode {

    public DrawCode() {
    }

    @Id
    //兑奖码
    private String code;

    //使用状态
    private String status;


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
