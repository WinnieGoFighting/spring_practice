package com.ni.service;

import com.ni.dao.impl.AccountDaoImpl;
import com.ni.service.impl.AccountServiceImpl;
import org.springframework.stereotype.Component;


public interface AccountService  {
    void saveAccount();
    
}
