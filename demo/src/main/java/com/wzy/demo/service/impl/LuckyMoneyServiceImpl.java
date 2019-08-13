package com.wzy.demo.service.impl;

import com.wzy.demo.dao.LuckyMoneyDao;
import com.wzy.demo.enums.ResultEnum;
import com.wzy.demo.exception.DemoException;
import com.wzy.demo.service.LuckMoneyService;
import com.wzy.demo.vo.LuckyMoney;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class LuckyMoneyServiceImpl implements LuckMoneyService {
    private static final Logger log = LoggerFactory.getLogger(LuckyMoneyServiceImpl.class);

    @Autowired
    private LuckyMoneyDao luckyMoneyDao;


    @Override
    //事务是数据库的事务，是数据库提供的，事务注解只是对事务的操作（提交或者回滚）
    //mySql的有些引擎（针对表的引擎）是不支持事务的，引擎InnoDB是支持的
    //加是事务是为了使
    //重要的是spring只回滚RuntimeException异常的事务,可以看下下面的例子
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

        /* start--这里可以加个可以回滚的异常，来测试一下事务回滚, 这里两条数据都未插入，这个异常属于RuntimeException */
//        int A = 1/0;
        /* end--这里可以加个可以回滚的异常，来测试一下事务回滚, 这里两条数据都未插入，这个异常属于RuntimeException */


        /* start--这里可以加个不回滚得异常，两条数据够插入了，IOException不回滚，只有RuntimeException异常回滚 */
//        FileWriter fw = null;// 不能在try中声明，这样会导致finally中无法只用；
//        try {
//            fw = new FileWriter("K:/ppt/text.txt");// 抛出异常的原因：可能找不到文件路径；
//            fw.write("规划局考虑到");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != fw) {
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        /* end--这里可以加个不回滚得异常，两条数据够插入了，IOException不回滚，只有RuntimeException异常回滚 */


        /* start--这里可以加个回滚的异常，两条数据都没插入，IOException不回滚，我们可以手动抛一个RuntimeException异常进行回滚  */
        FileWriter fw = null;// 不能在try中声明，这样会导致finally中无法只用；
        try {
            fw = new FileWriter("K:/ppt/text.txt");// 抛出异常的原因：可能找不到文件路径；
            fw.write("规划局考虑到");
        } catch (IOException e) {
            log.error("【系统IO异常】",e);
            //抛出RuntimeException异常进行事务回滚，DemoException自定义异常，继承了RuntimeException
            throw new DemoException(ResultEnum.UNKNOW_ERROR);
        } finally {
            if (null != fw) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        /* end--这里可以加个回滚的异常，两条数据都没插入，IOException不回滚，我们可以手动抛一个RuntimeException异常进行回滚  */

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
