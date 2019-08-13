package com.wzy.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.util.Properties;

/**
 * @ClassName BeanConfiguration
 * @Description 读取配置文件添加到spring容器
 * @Author wzy
 * @Date 2019/8/8 10:25
 * @Version 1.0
 */

//@Configuration标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
@Configuration
public class BeanConfiguration {
    private static final Logger log = LoggerFactory.getLogger(BeanConfiguration.class);

    @Bean
    public YamlConfigurerUtil ymlConfigurerUtil() {
        //1:加载配置文件
        Resource app = new ClassPathResource("application.yml");
        Resource appDev = new ClassPathResource("application-dev.yml");
        Resource appProd = new ClassPathResource("application-prod.yml");
        Resource appTest = new ClassPathResource("application-test.yml");
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        // 2:将加载的配置文件交给 YamlPropertiesFactoryBean
        yamlPropertiesFactoryBean.setResources(app);
        // 3：将yml转换成 key：val
        Properties properties = yamlPropertiesFactoryBean.getObject();
        String active = properties.getProperty("spring.profiles.active");
        if (active == "" || active == null) {
            log.info("未找到spring.profiles.active配置！");
        } else {
            //判断当前配置是什么环境
            if ("dev".equals(active)) {
                log.info("当前配置是dev环境！");
                yamlPropertiesFactoryBean.setResources(app, appDev);
            } else if ("prod".equals(active)) {
                log.info("当前配置是prod环境！");
                yamlPropertiesFactoryBean.setResources(app, appProd);
            } else if ("test".equals(active)) {
                log.info("当前配置是test环境！");
                yamlPropertiesFactoryBean.setResources(app, appTest);
            }
        }
        // 4: 将Properties 通过构造方法交给我们写的工具类
        YamlConfigurerUtil ymlConfigurerUtil = new YamlConfigurerUtil(yamlPropertiesFactoryBean.getObject());
        return ymlConfigurerUtil;
    }

}
