package com.wzy.demo.util;

import java.util.Properties;

/**
 * @ClassName YamlConfigurerUtil
 * @Description 读取配置文件key，value
 * @Author wzy
 * @Date 2019/8/8 10:44
 * @Version 1.0
 */
public class YamlConfigurerUtil {

    private Properties ymlProperties;

    public YamlConfigurerUtil(Properties properties){
        ymlProperties = properties;
    }

    public String getStrYmlVal(String key){
        return ymlProperties.getProperty(key);
    }

}
