package com.ni.factory;

import com.ni.service.AccountService;
import com.ni.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
@Component("beanFactory")
public class BeanFactory {
    @Autowired
    @Qualifier("accountService")
    private final AccountService accountService;

    @Autowired
    private TransactionManager txManager;


    public BeanFactory(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     * @return
     */

    @Bean(name="accountServiceProxy")
    public AccountService getAccountService() {
        return (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 添加事务的支持
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    System.out.println("加强方法执行了。。。");
                    txManager.beginTransaction();
                    Object val = method.invoke(accountService,args);
                    txManager.commitTransaction();
                    return val;
                } catch(Exception e) {
                    txManager.rollbackTransaction();
                    throw new RuntimeException(e);
                } finally {
                    txManager.releaseTransaction();
                }
            }
        });
    }
}
