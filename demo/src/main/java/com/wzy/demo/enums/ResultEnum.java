package com.wzy.demo.enums;

/**
 * 使用枚举对controller返回的结果编码进行管理
 */
public enum ResultEnum {
    SUCCESS("0000","success"),
    ERROR("0001","error"),
    UNKNOW_ERROR ("0002","系統异常"),
    SELF_ERROR ("0003","试试自定义业务异常")

    ;
    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
