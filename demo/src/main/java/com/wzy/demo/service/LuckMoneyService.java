package com.wzy.demo.service;

import com.wzy.demo.vo.LuckyMoney;

import java.math.BigDecimal;
import java.util.List;

public interface LuckMoneyService {
    LuckyMoney creatTwoLuckyMoney();

    List<LuckyMoney> getLuckMoneyList();

    LuckyMoney sendLuckMoney(String producer, String consumer, BigDecimal money);

    LuckyMoney getLuckMoney(Integer id);

    LuckyMoney updateLuckyMoney(Integer id, String producer, String consumer);
}
