package com.wzy.demo.controller;


import com.wzy.demo.service.ExceptionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此类对异常封装进行测试
 */
@RestController
public class ExceptionTestController {

    @Autowired
    private ExceptionTestService exceptionTestService;


    @GetMapping("/testEx/{num}")
    //测试一个自定义的业务校验规则异常
    public void testException(@PathVariable("num") Integer num) {
        exceptionTestService.testException(num);
    }

    @GetMapping("/testEx")
    //测试一个系统异常
    public void testException1() {
        exceptionTestService.testException(22);
        int A = 1/0;
    }
}
