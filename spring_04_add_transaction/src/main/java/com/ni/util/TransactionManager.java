package com.ni.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务相关的工具类，包含了 开启事务，提交事务，回滚事务，关闭事务
 */
@Component("txManager")
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭事务
     */
    public void releaseTransaction() {
        try {
            connectionUtils.getThreadConnection().close(); //并不是真的关闭连接，而是把连接还回连接池中
            //还需要把线程和连接解绑的操作
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
