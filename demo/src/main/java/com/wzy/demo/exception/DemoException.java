package com.wzy.demo.exception;


import com.wzy.demo.enums.ResultEnum;

/**
 * spring只对RuntimeException异常进行事务回滚
 */
public class DemoException extends RuntimeException{
    private ResultEnum resultEnum;

    public DemoException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }
}
