package com.ni.dao;
import com.ni.domain.Account;

public interface AccountDao {

    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);

}
