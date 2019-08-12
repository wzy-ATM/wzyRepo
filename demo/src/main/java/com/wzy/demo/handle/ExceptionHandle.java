package com.wzy.demo.handle;

import com.wzy.demo.util.Result;
import com.wzy.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ExceptionHandle
 * @Description controller层异常捕获
 * @Author wzy
 * @Date 2019/8/12 15:40
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionHandle {

    //指明捕获的异常类
    @ExceptionHandler(value = Exception.class)
    //因为不是@RestController所以需配合@ResponseBody返回json
    @ResponseBody
    public Result handle(Exception e){
        return ResultUtil.exception(e);
    }

}
