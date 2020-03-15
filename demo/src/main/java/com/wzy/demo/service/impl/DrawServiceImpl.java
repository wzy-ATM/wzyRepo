package com.wzy.demo.service.impl;

import com.wzy.demo.dao.DrawDao;
import com.wzy.demo.dao.LuckyMoneyDao;
import com.wzy.demo.enums.ResultEnum;
import com.wzy.demo.exception.DemoException;
import com.wzy.demo.service.DrawService;
import com.wzy.demo.service.LuckMoneyService;
import com.wzy.demo.vo.DrawCode;
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
import java.util.Random;

@Service
public class DrawServiceImpl implements DrawService {
    private static final Logger log = LoggerFactory.getLogger(DrawServiceImpl.class);
    @Autowired
    private DrawDao drawDao;


    @Override
    @Transactional
    public DrawCode creatCode() {
        synchronized (this) {
            DrawCode drawCode = null;
            try {
                List<DrawCode> list = drawDao.findByStatus();
                if(list.size() == 0){
                    return drawCode;
                }
                Random random = new Random();
                int n = random.nextInt(list.size());
                drawCode = list.get(n);
                drawCode.setStatus("1");
                drawDao.save(drawCode);
            } catch (Exception e) {
                throw new DemoException(ResultEnum.UNKNOW_ERROR);
            }
            return drawCode;
        }
    }

    @Override
    @Transactional
    public void addCode() {
        try {
            drawDao.deleteAll();
            for(int i = 1;i <= 20;i++){
                DrawCode drawCode = new DrawCode();
                drawCode.setStatus("0");
                drawCode.setCode(Integer.toString(i));
                drawDao.save(drawCode);
            }
        } catch (Exception e) {
            throw new DemoException(ResultEnum.UNKNOW_ERROR);
        }
    }
}
