package com.ni.test;
import com.ni.domain.Account;
import com.ni.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = container.getBean("accountService", AccountService.class);
        List<Account> accounts = service.findAllAccount();
        for (Account a:accounts)
            System.out.println(a);
    }

    @Test
    public void testFindOne() {
        ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = container.getBean("accountService", AccountService.class);
        Account a = service.findAccountById(1);
        System.out.println(a);
    }

    @Test
    public void testSave() {
        ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = container.getBean("accountService", AccountService.class);
        Account a = new Account();
        a.setName("ddd");
        a.setMoney(1000f);
        service.saveAccount(a);
    }

    @Test
    public void testUpdate() {
        ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = container.getBean("accountService", AccountService.class);
        Account a = new Account();
        a.setName("ddd");
        a.setMoney(2000f);
        a.setId(5);
        service.updateAccount(a);
    }

    @Test
    public void testDelete() {
        ApplicationContext container = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = container.getBean("accountService", AccountService.class);
        service.deleteAccount(5);
    }
}
