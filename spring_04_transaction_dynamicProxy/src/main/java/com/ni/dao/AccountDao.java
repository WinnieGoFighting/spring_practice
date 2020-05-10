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

    /**
     * 根据名称查询账户
     * @param name
     * @return 如果有唯一的名称，返回账户
     *          如果没有对应的账户，返回null
     *             如果有超过一个结果集，抛异常
     */
    Account findAccountByName(String name);
}
