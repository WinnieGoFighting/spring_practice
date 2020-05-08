package com.ni.service.impl;

import com.ni.dao.AccountDao;
import com.ni.service.AccountService;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {

    //如果是经常变化的数据，并不适用于注入的方法
    private AccountDao accountDao;
    private String name;
    private String age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("name is " + name + ", age is " + age + ", birthday is " + birthday);
        accountDao.saveAccount();
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
