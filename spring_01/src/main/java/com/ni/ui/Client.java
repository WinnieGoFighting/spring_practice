package com.ni.ui;

import com.ni.dao.AccountDao;
import com.ni.dao.impl.AccountDaoImpl;
import com.ni.service.AccountService;
import com.ni.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    private AccountService accountService;

    /**
     * 获取spring Ioc容器,并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //1. 获取核心容器对象
        //ApplicationContext的三种常用实现类：
            //ClassPathXmlApplicationContext:加载类路径下的配置文件,推荐
            //FileSystemXmlApplicationContext:加载磁盘任意路径下的配置文件（必须有访问权限）
            //AnnotationConfigApplicationContext：用于读取注解创建容器
        //核心容器的两个接口引发出的问题
            //ApplicationContext:采取的是立即加载的方式，一旦加载完配置文件，立刻生成配置文件中的对象-适合单例模式
                    //--实际开发模式中主要用ApplicationContext
            //BeanFactory:采取的是延迟加载的方式，什么时候根据id获取对象了，什么时候生成对象 -适合多例模式

        ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象,两种方式都可以
        AccountService s1= (AccountService) container.getBean("accountService");
        AccountService s2= (AccountService) container.getBean("accountService2");
        AccountService s3= (AccountService) container.getBean("accountService3");


       // AccountDao dao = container.getBean("accountDao", AccountDao.class);
//        System.out.println(s1);
//        System.out.println(s2);
        s1.saveAccount();
        s2.saveAccount();
        s3.saveAccount();
}
}
