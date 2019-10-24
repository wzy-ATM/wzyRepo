package com.wzy.demo.controller;

import com.wzy.demo.service.DrawService;
import com.wzy.demo.service.LuckMoneyService;
import com.wzy.demo.util.Result;
import com.wzy.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DrawController
 * @Description 模拟抽奖
 * @Author wzy
 * @Date 2019/10/24 12:40
 * @Version 1.0
 */
@RestController
public class DrawController {

    @Autowired
    private DrawService drawService;

    @GetMapping("/createDrawCode")
    public Result createDrawCode() {
        return ResultUtil.success(drawService.creatCode());
    }



}
