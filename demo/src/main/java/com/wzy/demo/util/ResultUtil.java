package com.wzy.demo.util;

/**
 * @ClassName ResultUtil
 * @Description controller返回结果工具类
 * @Author wzy
 * @Date 2019/8/12 16:08
 * @Version 1.0
 */
public class ResultUtil {

    private static String successCode = "0000";
    private static String successMsg = "success";
    private static String errorCode = "1111";
    private static String errorMsg = "fail";

    public static Result success(Object obj) {
        Result result = new Result();
        result.setData(obj);
        result.setMsg(ResultUtil.successMsg);
        result.setCode(ResultUtil.successCode);
        return result;
    }

    public static Result exception(Exception e) {
        Result result = new Result();
        result.setData(null);
        result.setMsg(e.getMessage());
        result.setCode(ResultUtil.errorCode);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setData(null);
        result.setMsg(ResultUtil.errorMsg);
        result.setCode(ResultUtil.errorCode);
        return result;
    }
}
