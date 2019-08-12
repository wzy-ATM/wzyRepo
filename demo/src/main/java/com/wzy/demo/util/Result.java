package com.wzy.demo.util;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @ClassName Result
 * @Description controller的返回实体
 * @Author wzy
 * @Date 2019/8/12 15:42
 * @Version 1.0
 */
public class Result<T> {
    //返回编码
    private String code;
    //返回结果,其实我理解这里不需要泛型，可以使用Object；不指定泛型的话，这里data其实就是Object;
    //具体看下下面的main方法
    private T data;
    //返回提示语
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        //这里对泛型做个理解测试

        //1、这里不指定泛型，data可以是任意的Object
        Result rest = new Result();
        rest.setData("");

        //2、这里指定泛型为Integer，data只能是指定的类型
        Result<Integer> rest1 = new Result<Integer>();
        rest1.setData(12);
    }
}
