package com.ni.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * connection的工具类，用于从数据源中获取一个链接，并且实现和线程的绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        //1 先从ThreadLocal上获取
        //2 判断当前线程上是否有连接
        //3 从数据源中获取一个连接，并且存入ThreadLocal中
        Connection conn = tl.get();
        try {
            if (conn == null) {
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把线程和连接解绑的操作
     */
    public void removeConnection() {
        tl.remove();
    }
}
