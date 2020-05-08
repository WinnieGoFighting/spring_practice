package com.ni.factory;

import com.ni.service.AccountService;
import com.ni.service.impl.AccountServiceImpl;

import java.util.Date;

/**
 * 模拟一个工厂类，该类可能存在于jar包中，我们无法通过修改源码的方式来提供默认构造函数
 */
public class InstanceFactory {
    public AccountService getAccountService() {
        return new AccountServiceImpl("test","18",new Date());
    }
}

