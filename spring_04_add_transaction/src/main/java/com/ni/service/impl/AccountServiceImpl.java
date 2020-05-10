package com.ni.service.impl;
import com.ni.dao.AccountDao;
import com.ni.domain.Account;
import com.ni.service.AccountService;
import com.ni.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
//事务的控制因该都放在业务层！

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager txManager;

    public List<Account> findAllAccount() {
        try {
            txManager.beginTransaction();
            List<Account> list = accountDao.findAllAccount();
            txManager.commitTransaction();
            return list;
        } catch(Exception e) {
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseTransaction();
        }
    }

    public Account findAccountById(Integer id) {
        try {
            txManager.beginTransaction();
            Account a = accountDao.findAccountById(id);
            txManager.commitTransaction();
            return a;
        } catch(Exception e) {
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseTransaction();
        }
    }

    public void saveAccount(Account account) {
        try {
            txManager.beginTransaction();
            accountDao.saveAccount(account);
            txManager.commitTransaction();
        } catch(Exception e) {
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseTransaction();
        }
    }

    public void updateAccount(Account account) {
        try {
            txManager.beginTransaction();
            accountDao.updateAccount(account);
            txManager.commitTransaction();
        } catch(Exception e) {
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseTransaction();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            txManager.beginTransaction();
            accountDao.deleteAccount(id);
            txManager.commitTransaction();
        } catch(Exception e) {
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseTransaction();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            txManager.beginTransaction();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
            txManager.commitTransaction();
        } catch(Exception e) {
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseTransaction();
        }
    }
}

