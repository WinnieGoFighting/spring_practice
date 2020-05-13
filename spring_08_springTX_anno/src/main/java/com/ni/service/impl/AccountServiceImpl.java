package com.ni.service.impl;
import com.ni.dao.AccountDao;
import com.ni.domain.Account;
import com.ni.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
//事务的控制因该都放在业务层！

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true) //只读型配置
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
            //int i = 1/0;
    }
}
