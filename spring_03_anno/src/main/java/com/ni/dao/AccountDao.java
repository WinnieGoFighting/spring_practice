package com.ni.dao;

import com.ni.domain.Account;

import java.util.List;

public interface AccountDao {
    //常用的增删改查
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);
}
