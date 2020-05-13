package config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring 的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan("com.ni")
@Import({JdbcConfiguration.class,TransactionConfiguration.class})
@PropertySource("db.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}
