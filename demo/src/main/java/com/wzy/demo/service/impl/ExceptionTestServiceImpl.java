package com.wzy.demo.service.impl;

import com.wzy.demo.enums.ResultEnum;
import com.wzy.demo.exception.DemoException;
import com.wzy.demo.service.ExceptionTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExceptionTestServiceImpl implements ExceptionTestService {
    private static final Logger log = LoggerFactory.getLogger(ExceptionTestServiceImpl.class);

    @Override
    public void testException(Integer num) {
        if(20 >= num &&  num > 10){
            //抛出一个业务异常
            throw new DemoException(ResultEnum.ERROR);
        }else if(num>20){
            throw new DemoException(ResultEnum.SELF_ERROR);
        }else{
            log.info("没有异常信息！");
        }
    }
}
