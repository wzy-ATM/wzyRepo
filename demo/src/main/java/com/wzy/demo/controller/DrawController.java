package com.wzy.demo.controller;

import com.wzy.demo.service.DrawService;
import com.wzy.demo.service.LuckMoneyService;
import com.wzy.demo.util.Result;
import com.wzy.demo.util.ResultUtil;
import com.wzy.demo.vo.DrawCode;
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

    @GetMapping("/createDrawCode1")
    public Result createDrawCode1() {
        DrawCode drawCode = drawService.creatCode();
        return ResultUtil.success(drawCode==null?"没有兑奖码了哦！！！":"您好，您的兑奖码是"+drawCode.getCode());
    }

    @GetMapping("/createDrawCode")
    public String createDrawCode() {
        DrawCode drawCode = drawService.creatCode();
        return drawCode==null?"没有兑奖码了哦！！！":"您好，您的兑奖码是"+drawCode.getCode();
    }

    @GetMapping("/addDrawCode")
    public Result addDrawCode() {
        drawService.addCode();
        return ResultUtil.success(null);
    }



}
