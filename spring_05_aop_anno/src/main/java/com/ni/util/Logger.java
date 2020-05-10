package com.ni.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
@Component("logger")
@Aspect //注意基于注解的四个通知方法执行的顺序有问题，用环绕通知可以手动指定顺序，就不会出错了
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行前执行（切入点方法就是我们的业务层方法）
     */
    @Pointcut("execution(* com.ni.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 前置通知
     */
    //@Before("pt1()")
    public void beforePrintLog() {
        System.out.println("Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
    //@AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }

    /**
     * 异常通知
     */
    //@AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
    //@After("pt1()")
    public void afterPrintLog() {
        System.out.println("Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知:是spring为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     * 问题：配置了环绕通之后，切入点方法没有执行，而通知方法执行了
     * 解决：需要有明确的切入点方法调用
     *      spring提供了一个接口：ProceedingJoinPoint  该接口的方法proceed相当于明确调用切入点方法
     *      */

    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint point) {
        Object rtVal = null;
        try {
            Object[] args = point.getArgs();
            System.out.println("Logger类中的beforePrintLog方法开始记录日志了。。。");
            rtVal = point.proceed(args);
            System.out.println("Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
            return rtVal;
        } catch(Throwable t) {
            System.out.println("Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
            throw new RuntimeException(t);
        } finally {
            System.out.println("Logger类中的afterPrintLog方法开始记录日志了。。。");
        }
    }
}
