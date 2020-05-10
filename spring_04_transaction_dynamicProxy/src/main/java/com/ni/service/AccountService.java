package com.ni.service;

import com.ni.domain.Account;

import java.util.List;

public interface AccountService {
    //常用的增删改查
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);

    /**
     *
     * @param sourceName 转入账户名称
     * @param targetName 转出账户名称
     * @param money 交易金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
