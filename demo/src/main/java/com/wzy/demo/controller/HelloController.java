package com.wzy.demo.controller;

import com.wzy.demo.util.YamlConfigurerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

/**
 * @ClassName HelloController
 * @Description 哈哈哈，hello world我又来了
 * @Author wzy
 * @Date 2019/8/8 9:56
 * @Version 1.0
 */

//@Controller该注解需要json格式数据需要与@ResponseBody注解配合使用
//spring4增加了@RestController，返回体会自动转换为json格式
@RestController
public class HelloController {

    //1、使用@Autowired的当前类也必须由spring容器托管（打@Coponent、@Controller、@Service 、@repository）
    //2、不管是public 和  private 修饰的字段都可以自动注入
    //3、默认情况下，使用@Autowired注解的属性一定要被装配，如果在容器中找不到该类型的bean注入，就会报错。如果允许不被装配就可以将@Autowired的required属性为false
    //4、@Autowired 是基于类型的注入，如果当前类型属性在容器中只有一个Bean, 那么属性名不限制，但一般建议遵循类名首字母小写的规则‘
    //5、如果当前属性类型在容器中有个多个Bean,那么必须要通过属性名 或者 @Qualifier 指定Bean name
    //6、@Autowired 可以打在XXX[] 、List<XXX>上 ，此时会将容器中所有XXX类型的bean 都注入进去、且属性名没有约束，但是注意可以通过@Qualifier指定注入指定beanName的bean，属性名是没有约束作用的
    //7、@Autowired可以打在Map<String,XXX>上，此时所有XXX类型的bean都会被注入 ，beanName 为key ,对象为value，但是注意可以通过@Qualifier指定注入指定beanName的bean，属性名是没有约束作用的
    @Autowired
    private YamlConfigurerUtil yamlConfigurerUtil;

    @GetMapping("/sayGet/{Money}")
    public String say(@PathVariable("Money") BigDecimal Money) {
        yamlConfigurerUtil.getStrYmlVal("limit.minMoney");
        String msg = "哈哈，我来发红包了，一共发了"
                + Money
                + "元（最小红包" + yamlConfigurerUtil.getStrYmlVal("limit.minMoney")
                + ",最大红包" + yamlConfigurerUtil.getStrYmlVal("limit.maxMoney") + "）";
        return msg;
    }

    @PostMapping("/sayPost/{Money}")
    public String say1(@PathVariable("Money") BigDecimal Money) {
        String msg = "哈哈，我来发红包了，一共发了"
                + Money
                + "元（最小红包" + yamlConfigurerUtil.getStrYmlVal("limit.minMoney")
                + ",最大红包" + yamlConfigurerUtil.getStrYmlVal("limit.maxMoney") + "）";
        return msg;
    }

    @RequestMapping("/sayPostOrGet/{Money}")
    public String say2(@PathVariable("Money") BigDecimal Money) {
        String msg = "哈哈，我来发红包了，一共发了"
                + Money
                + "元（最小红包" + yamlConfigurerUtil.getStrYmlVal("limit.minMoney")
                + ",最大红包" + yamlConfigurerUtil.getStrYmlVal("limit.maxMoney") + "）";
        return msg;
    }

    @RequestMapping(value = "/sayRequestPost/{Money}", method = RequestMethod.POST)
    public String say3(@PathVariable("Money") BigDecimal Money) {
        String msg = "哈哈，我来发红包了，一共发了"
                + Money
                + "元（最小红包" + yamlConfigurerUtil.getStrYmlVal("limit.minMoney")
                + ",最大红包" + yamlConfigurerUtil.getStrYmlVal("limit.maxMoney") + "）";
        return msg;
    }

    @RequestMapping(value = "/sayRequestGet/{Money}", method = RequestMethod.GET)
    public String say4(@PathVariable(value = "Money", required = false) BigDecimal Money) {
        String msg = "哈哈，我来发红包了，一共发了"
                + Money
                + "元（最小红包" + yamlConfigurerUtil.getStrYmlVal("limit.minMoney")
                + ",最大红包" + yamlConfigurerUtil.getStrYmlVal("limit.maxMoney") + "）";
        return msg;
    }


}
