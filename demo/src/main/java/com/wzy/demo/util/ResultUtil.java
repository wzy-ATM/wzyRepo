package com.wzy.demo.util;

import com.wzy.demo.enums.ResultEnum;

/**
 * @ClassName ResultUtil
 * @Description controller返回结果工具类
 * @Author wzy
 * @Date 2019/8/12 16:08
 * @Version 1.0
 */
public class ResultUtil {

    public static Result success(Object obj) {
        Result result = new Result();
        result.setData(obj);
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setCode(ResultEnum.SUCCESS.getCode());
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        return result;
    }

    public static Result unknowError() {
        Result result = new Result();
        result.setMsg(ResultEnum.UNKNOW_ERROR.getMsg());
        result.setCode(ResultEnum.UNKNOW_ERROR.getCode());
        return result;
    }

}
