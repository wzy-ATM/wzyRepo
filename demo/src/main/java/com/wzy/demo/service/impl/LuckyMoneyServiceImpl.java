package com.wzy.demo.service.impl;

import com.wzy.demo.dao.LuckyMoneyDao;
import com.wzy.demo.service.LuckMoneyService;
import com.wzy.demo.vo.LuckyMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class LuckyMoneyServiceImpl implements LuckMoneyService {
    @Autowired
    private LuckyMoneyDao luckyMoneyDao;


    @Override
    //事务是数据库的事务，是数据库提供的，事务注解只是对事务的操作（提交或者回滚）
    //mySql的有些引擎（针对表的引擎）是不支持事务的，引擎InnoDB是支持的
    //加是事务是为了使
    @Transactional
    public LuckyMoney creatTwoLuckyMoney() {
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setProducer("事务-发送");
        luckyMoney.setConsumer("事务-接受");
        luckyMoney.setMoney(new BigDecimal("1000"));
        luckyMoneyDao.save(luckyMoney);

        LuckyMoney luckyMoney1 = new LuckyMoney();
        luckyMoney1.setProducer("事务-发送1");
        luckyMoney1.setConsumer("事务-接受1");
        luckyMoney1.setMoney(new BigDecimal("100"));
        luckyMoneyDao.save(luckyMoney1);
        return luckyMoney;
    }

    @Override
    public List<LuckyMoney> getLuckMoneyList() {
        return luckyMoneyDao.findAll();
    }

    @Override
    public LuckyMoney sendLuckMoney(String producer, String consumer, BigDecimal money) {
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setProducer(producer);
        luckyMoney.setConsumer(consumer);
        luckyMoney.setMoney(money);
        luckyMoneyDao.save(luckyMoney);
        return luckyMoney;
    }

    @Override
    public LuckyMoney getLuckMoney(Integer id) {
        return luckyMoneyDao.findById(id).orElse(null);
    }

    @Override
    public LuckyMoney updateLuckyMoney(Integer id, String producer, String consumer) {
        Optional<LuckyMoney> op = luckyMoneyDao.findById(id);
        LuckyMoney luckyMoney = null;
        if (op.isPresent()) {
            luckyMoney = op.get();
            luckyMoney.setProducer(producer);
            luckyMoney.setConsumer(consumer);
            luckyMoneyDao.save(luckyMoney);
        }
        return luckyMoney;
    }
}
