package com.ni.service;

import com.ni.domain.Account;

public interface AccountService {
    Account findAccountById(Integer acctId);
    void transfer(String sourceName, String targetName, Float money);
}
