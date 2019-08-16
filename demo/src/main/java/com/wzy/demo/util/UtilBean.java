package com.wzy.demo.util;

import com.wzy.demo.service.LuckMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @ClassName UtilBean
 * @Description 这个util示例一个工具里注入service或者dao
 * @Author wzy
 * @Date 2019/8/16 11:27
 * @Version 1.0
 */
//泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
//把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
@Component
public class UtilBean {
    //静态变量、静态方法不是对象的属性，而是一个类的属性，
    //所以静态方法是属于类（class）的，普通方法才是属于实体对象（也就是New出来的对象）的，
    //spring依赖注入即在容器中实例化对象bean，依赖注入的主要目的,是让容器去产生一个对象的实例,然后在整个生命周期中都使用他们
    //而static是类属性，不会实例化对象，所以不能使用@Autowired注入静态变量
    //所以这种方式是错误的，肯定是空指针的
    //@Autowired
    //private static LuckMoneyService luckMoneyService;


    //解决方法1如下：构造函数注入spring实例化的对象，将spring实例化的对象赋值给静态变量
    private static LuckMoneyService luckMoneyService;
    public UtilBean(LuckMoneyService luckMoneyService) {
        UtilBean.luckMoneyService = luckMoneyService;
    }
    //非静态方法可以访问类中的任何成员，静态方法只能访问类中的静态成员；
    public static List getLuckMoneyList(){
        return luckMoneyService.getLuckMoneyList();
    }

    //解决方法2如下：set方法注入spring实例化的对象，将spring实例化的对象赋值给静态变量
    private static LuckMoneyService luckMoneyService1;
    @Autowired
    public static void setLuckMoneyService1(LuckMoneyService luckMoneyService) {
        UtilBean.luckMoneyService1 = luckMoneyService;
    }
    //非静态方法可以访问类中的任何成员，静态方法只能访问类中的静态成员；
    public static List getLuckMoneyList1(){
        return luckMoneyService1.getLuckMoneyList();
    }
    //解决方法3如下：用@PostConstruct注解
    //@PostConstruct注解好多人以为是Spring提供的。其实是Java自己的注解。
    //Java中该注解的说明：@PostConstruct该注解被用来修饰一个非静态的void（）方法。被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行。
    //通常我们会是在Spring框架中使用到@PostConstruct注解 该注解的方法在整个Bean初始化中的执行顺序：
    //Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
    private static LuckMoneyService LuckMoneyService2;
    @Autowired
    private LuckMoneyService luckMoneyService3;
    @PostConstruct
    public void beforeInit() {
        LuckMoneyService2 = luckMoneyService3;
    }
    //非静态方法可以访问类中的任何成员，静态方法只能访问类中的静态成员；
    public static List getLuckMoneyList3(){
        return LuckMoneyService2.getLuckMoneyList();
    }

}
