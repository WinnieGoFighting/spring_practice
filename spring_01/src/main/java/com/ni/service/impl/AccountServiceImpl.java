package com.ni.service.impl;

import com.ni.dao.AccountDao;
import com.ni.dao.impl.AccountDaoImpl;
import com.ni.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    //如果是经常变化的数据，并不适用于注入的方法
    private AccountDao accountDao;
    private String name;
    private String age;
    private Date birthday;

    public AccountServiceImpl(String name, String age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("name is " + name + ", age is " + age + ", birthday is " + birthday);

    }
}
