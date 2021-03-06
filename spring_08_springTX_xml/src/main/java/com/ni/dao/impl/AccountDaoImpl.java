package com.ni.dao.impl;

import com.ni.dao.AccountDao;
import com.ni.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

//如果用注解开发，这种继承的写法会比较麻烦！
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

//    private JdbcTemplate template;
//
//    public void setTemplate(JdbcTemplate template) {
//        this.template = template;
//    }

    public Account findAccountById(Integer accountId) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if (list.isEmpty())
            return null;
        if (list.size()>1)
            throw new RuntimeException("结果集不唯一");
        return list.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?, money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
