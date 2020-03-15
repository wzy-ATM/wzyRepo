package com.wzy.demo.service;

import com.wzy.demo.vo.DrawCode;
import java.math.BigDecimal;
import java.util.List;

public interface DrawService {

    DrawCode creatCode();
    void addCode();

}
