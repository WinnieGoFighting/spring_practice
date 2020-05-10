package com.ni.test;

import com.ni.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = container.getBean("accountService",AccountService.class);
        service.saveAccount();
    }
}
