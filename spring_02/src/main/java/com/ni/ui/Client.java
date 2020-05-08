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

        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象,两种方式都可以
        AccountService s1= (AccountService) container.getBean("accountServiceImpl");

        System.out.println(s1);

        s1.saveAccount();
        container.close();
    }
}
