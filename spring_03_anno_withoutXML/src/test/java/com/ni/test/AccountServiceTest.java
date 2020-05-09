package com.ni.test;
import com.ni.domain.Account;
import com.ni.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
* Spring 整合junit的配置
* 1.导入Spring整合junit的jar包|坐标
* 2.使用junit提供的一个注解把原有的main方法替换了，替换成spring提供的 @Runwith
* 3.告知 spring的运行器，spring和ioc创建是基于xml还是注解的，并说明位置 @ContextConfiguration
*   location:指定xml的文件位置，加上classpath关键字，表示在类路径下
*       @ContextConfiguration(locations="classpath:bean.xml")
*   classes:指定注解类所在位置
*
* 细节：当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
*
* */

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private AccountService service;
    @Test
    public void testFindAll() {
       // ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
       // AccountService service = container.getBean("accountService", AccountService.class);
        List<Account> accounts = service.findAllAccount();
        for (Account a:accounts)
            System.out.println(a);
    }

    @Test
    public void testFindOne() {
        //ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //AccountService service = container.getBean("accountService", AccountService.class);
        Account a = service.findAccountById(1);
        System.out.println(a);
    }

    @Test
    public void testSave() {
        //ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
       // AccountService service = container.getBean("accountService", AccountService.class);
        Account a = new Account();
        a.setName("ddd");
        a.setMoney(1000f);
        service.saveAccount(a);
    }

    @Test
    public void testUpdate() {
       // ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //AccountService service = container.getBean("accountService", AccountService.class);
        Account a = new Account();
        a.setName("ddd");
        a.setMoney(2000f);
        a.setId(5);
        service.updateAccount(a);
    }

    @Test
    public void testDelete() {
        //ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //AccountService service = container.getBean("accountService", AccountService.class);
        service.deleteAccount(5);
    }
}
