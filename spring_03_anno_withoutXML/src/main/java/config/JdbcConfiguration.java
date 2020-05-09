package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfiguration {

    //runner 应该是多例，如何改进？
    @Bean(name="runner")
    @Scope("prototype")

    //如果有多个数据源，需要让dataSource的参数名字与bean对象的id对应
    //或者可以用@Qualifier注解 用于方法中
    //public QueryRunner createQueryRunner(@Qualifier("ds2") DataSource dataSource)

    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name="dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql:///spring?useSSL=false");
        ds.setUser("root");
        ds.setPassword("12345");
        return ds;
    }
}
