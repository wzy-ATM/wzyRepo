package com.wzy.demo.controller;

import com.wzy.demo.service.LuckMoneyService;
import com.wzy.demo.util.Result;
import com.wzy.demo.util.ResultUtil;
import com.wzy.demo.vo.LuckyMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName LuckyMoneyController
 * @Description 发红包了
 * @Author wzy
 * @Date 2019/8/8 9:56
 * @Version 1.0
 */
@RestController
public class LuckyMoneyController {

    @Autowired
    private LuckMoneyService luckMoneyService;

    @GetMapping("/getLuckMoneyList")
    public Result getLuckMoneyList() {
        return ResultUtil.success(luckMoneyService.getLuckMoneyList());
    }

    @GetMapping("/sendLuckMoney/{producer}/{consumer}/{money}")
    public Result sendLuckMoney(@PathVariable("producer") String producer, @PathVariable("consumer") String consumer, @PathVariable("money") BigDecimal money) {
        return ResultUtil.success(luckMoneyService.sendLuckMoney(producer,consumer,money));
    }

    @GetMapping("/getLuckMoney/{id}")
    public Result getLuckMoney(@PathVariable("id") Integer id) {
        return ResultUtil.success(luckMoneyService.getLuckMoney(id));
    }

    @GetMapping("/updateLuckyMoney/{producer}/{consumer}/{id}")
    public Result updateLuckyMoney(@PathVariable("id") Integer id, @PathVariable("producer") String producer, @PathVariable("consumer") String consumer) {
        return ResultUtil.success(luckMoneyService.updateLuckyMoney(id,producer,consumer));
    }
}
