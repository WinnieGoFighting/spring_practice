package com.ni.dao.impl;

import com.ni.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("accountDao方法执行...");
    }
}
