package com.ni.test;
import com.ni.domain.Account;
import com.ni.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService service;

    @Test
    public void testTransfer(){
        service.transfer("aaa","bbb",100f);
    }
}
