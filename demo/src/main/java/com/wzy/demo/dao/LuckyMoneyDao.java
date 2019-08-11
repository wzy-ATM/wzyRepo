package com.wzy.demo.dao;

import com.wzy.demo.vo.LuckyMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckyMoneyDao extends JpaRepository<LuckyMoney,Integer> {

}
