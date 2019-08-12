package com.wzy.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;


/**
 * @ClassName HttpAspect
 * @Description http请求打印日志切面
 * @Author wzy
 * @Date 2019/8/12 13:40
 * @Version 1.0
 * <p>
 * aop简介：
 * AOP技术恰恰相反，它利用一种称为"横切"的技术，剖解开封装的对象内部，
 * 并将那些影响了多个类的公共行为封装到一个可重用模块，并将其命名为"Aspect"，即切面。
 * 所谓"切面"，简单说就是那些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，
 * 便于减少系统的重复代码，降低模块之间的耦合度，并有利于未来的可操作性和可维护性
 * <p>
 * aop作用：
 * 使用"横切"技术，AOP把软件系统分为两个部分：核心关注点和横切关注点。
 * 业务处理的主要流程是核心关注点，与之关系不大的部分是横切关注点。
 * 横切关注点的一个特点是，他们经常发生在核心关注点的多处，而各处基本相似，
 * 比如缓存控制、缓存控制、事务控制、异常处理、审计日志、性能监控、分布式追踪。
 * AOP的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。
 * <p>
 * Spring对AOP的支持：
 * Spring中AOP代理由Spring的IOC容器负责生成、管理，其依赖关系也由IOC容器负责管理。因此，AOP代理可以直接使用容器中的其它bean实例作为目标，这种关系可由IOC容器的依赖注入提供。Spring创建代理的规则为：
 * 1、默认使用Java动态代理来创建AOP代理，这样就可以为任何接口实例创建代理了
 * 2、当需要代理的类不是代理接口的时候，Spring会切换为使用CGLIB代理，也可强制使用CGLIB
 * AOP编程其实是很简单的事情，纵观AOP编程，程序员只需要参与三个部分：
 * 1、定义普通业务组件
 * 2、定义切入点，一个切入点可能横切多个业务组件
 * 3、定义增强处理，增强处理就是在AOP框架为普通业务组件织入的处理动作
 * 所以进行AOP编程的关键就是定义切入点和定义增强处理，一旦定义了合适的切入点和增强处理，AOP框架将自动生成AOP代理，即：代理对象的方法=增强处理+被代理对象的方法。
 */


/**
 * aop简介：
 * AOP技术恰恰相反，它利用一种称为"横切"的技术，剖解开封装的对象内部，
 * 并将那些影响了多个类的公共行为封装到一个可重用模块，并将其命名为"Aspect"，即切面。
 * 所谓"切面"，简单说就是那些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，
 * 便于减少系统的重复代码，降低模块之间的耦合度，并有利于未来的可操作性和可维护性
 */

/**
 * aop作用：
 * 使用"横切"技术，AOP把软件系统分为两个部分：核心关注点和横切关注点。
 * 业务处理的主要流程是核心关注点，与之关系不大的部分是横切关注点。
 * 横切关注点的一个特点是，他们经常发生在核心关注点的多处，而各处基本相似，
 * 比如缓存控制、缓存控制、事务控制、异常处理、审计日志、性能监控、分布式追踪。
 * AOP的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。
 */

/**
 *Spring对AOP的支持：
 *  Spring中AOP代理由Spring的IOC容器负责生成、管理，其依赖关系也由IOC容器负责管理。因此，AOP代理可以直接使用容器中的其它bean实例作为目标，这种关系可由IOC容器的依赖注入提供。Spring创建代理的规则为：
 *    1、默认使用Java动态代理来创建AOP代理，这样就可以为任何接口实例创建代理了
 *    2、当需要代理的类不是代理接口的时候，Spring会切换为使用CGLIB代理，也可强制使用CGLIB
 *  AOP编程其实是很简单的事情，纵观AOP编程，程序员只需要参与三个部分：
 *    1、定义普通业务组件
 *    2、定义切入点，一个切入点可能横切多个业务组件
 *    3、定义增强处理，增强处理就是在AOP框架为普通业务组件织入的处理动作
 * 所以进行AOP编程的关键就是定义切入点和定义增强处理，一旦定义了合适的切入点和增强处理，AOP框架将自动生成AOP代理，即：代理对象的方法=增强处理+被代理对象的方法。
 */

/**
 * @Aspect ：标注在类上，表示当前类是一个切面类；
 * @PointCut：切入点；
 * @Before：前置通知，即在某个连接点之前执行通知；
 * @AfterReturning：后置通知，即在某个连接点正常完成后执行通知，通常在一个匹配的方法返回的时候执行；
 * @AfterThrowing：异常通知，即在方法抛出异常退出时执行通知；
 * @After：最终通知，即某个连接点退出时执行通知；
 * @Around：环绕通知，它是最强大也是最麻烦的通知，它可以在方法调用前后完成自定义的行为，它可以自己选择是否继续执行连接点或者直接返回或者抛出异常来结束执行；
 */
@Aspect
@Component
public class HttpAspect {
    //spring自带的日志框架
    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    //切入点，将所有http请求controller方法做为切入点
    //匹配com.wzy.demo.controller包下所有包和子包中的类中的所有方法
    @Pointcut("within(com.wzy.demo.controller..*)")
    public void log() {
    }

    //切入点之前执行，log()即切入点， 由@Pointcut指定
    @Before("log()")
    public void doBefore(JoinPoint jp) {
        log.info("-----doBefore----start----");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("-----url{" + request.getRequestURL() + "}");
        log.info("-----method{" + request.getMethod() + "}");
        log.info("-----ip{" + request.getRemoteAddr() + "}");
        log.info("-----class_method{" + jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName() + "}");
        Object[] args = jp.getArgs();
        for (Object obj : args) {
            log.info("-----args{" + obj.toString() + "}");
        }
        log.info("-----doBefore----end----");
    }

    //切入点之后执行，log()即切入点， 由@Pointcut指定
    @After("log()")
    public void doAfter(JoinPoint jp) {
        log.info("-----doAfter----over----");

    }
    //通常在一个方法返回的时候执行
    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj) {
        log.info("-----doAfterReturning----start----");
        log.info("-----response{"+obj.toString()+"}");
        log.info("-----doAfterReturning----end----");
    }

}
