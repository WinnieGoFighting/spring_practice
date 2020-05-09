package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/*该类是一个配置类，它的作用和bean.xml是一样的
spring 中的新注解
@Configuration:
    作用：指定当前类是一个配置类
    细节：当配置类作为AnnotationConfigApplicationContext对象创建参数时，该注解可以不写
@ComponentScan
    作用：用于通过注解指定spring在创建容器时要扫描的包
    属性：value和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包
    配置了此注解就等同于配置了xml的如下语句
     <context:component-scan base-package="com.ni"></context:component-scan>
 @Bean
    作用：用于把点前方法的返回值作为bean对象存入spring容器中
    属性：name, 用于指定bean的id,默认值是当前方法的名称
    细节：当我们使用注解配置方法时，如果方法有参数，spring回去容器中查找相匹配的bean对象

 @Import
    作用：用于导入其他的配置类
    属性：value 用于指定其他配置类的字节码
        当我们使用import注解后，有import注解的类就是父配置类（SpringConfiguration），而导入的都是子配置类(JdbcConfiguration)
*/
//@Configuration
@Import(JdbcConfiguration.class)
@ComponentScan("com.ni")
public class SpringConfiguration {
    //主配置内容。。。
}
