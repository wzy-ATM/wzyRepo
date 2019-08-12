package com.wzy.demo.util;

/**
 * @ClassName Result
 * @Description controller的返回实体
 * @Author wzy
 * @Date 2019/8/12 15:42
 * @Version 1.0
 */
public class Result {
    //返回编码
    private String code;
    //返回结果
    private Object data;
    //返回提示语
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
