package com.ni.service.impl;

import com.ni.dao.AccountDao;
import com.ni.dao.impl.AccountDaoImpl;
import com.ni.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 * 曾经的xml配置
 * <bean id="" class="" scope="" init-method="" destroy-method="">
 *     <property name="" value=""|ref=""></property>
 * </bean>
 *
 * 我们把注解分成以下几类
 * 1.用于创建对象的
 * @Component 作用：用于把当前类对象存入spring容器中
 *            属性：用于指定bean的id, 当我们不写是，它的默认值是当前类名，首字母改小写
 *
 *      @Controller：一般用于表现层
 *      @Service：一般用于业务层
 *      @Repository：一般用于持久层
 *      以上三个注解他们的作用和属性与Component一模一样
 *      它们是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 * 2.用于注入数据的
 * @Autowired:自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *            如果ioc容器中没有任何bean类型和要注入的变量类型匹配，则报错
 *            如果ioc容器中有多个类型匹配时，会通过比较bean id 和 定义的变量名来匹配，匹配得上就注入成功，匹配不上就报错
 * @Qualifier:作用，在按照类中注入的基础上再按照名称注入，它在给类成员注入时不能单独使用(与autowired同时使用)，但在给方法参数注入时可以
 *              属性：用于指定注入bean的id
 * @Resource:直接按照bean id 注入. 它可以独立使用
 *              属性：name:用于指定bean的id
 *以上单个注入都只能注入其他bean类型的数据，而基本类型和string类型无法使用上述注解实现
 * 另外，集合类型的注入只能通过xml
 * @Value: 用于注入基本类型和String类型的数据
 *          属性：value,用于指定数据的值，他可以使用spring的SpEl(也就是spring的el表达式) ${表达式}
 *
 *
 * 出现位置：可以是成员上，也可以是方法上
 * 细节：在使用注解注入时，set方法就不是必须的了
 *
 * 3.用于改变作用范围的
 * @Scope: 用于指定bean的作用范围
 *          属性：value:指定范围的取值 常用取值 singleton prototype 默认是单例的
 *
 * 4.和生命周期相关的
 *      它们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的
 *      @PostConstruct
 *      @PreDestroy

 */
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource(name="accountDao1")
    private AccountDao accountDao;
    public void saveAccount() {
        System.out.println("service的saveAccount()执行了");
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("init()方法执行了");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destropy()方法执行了");
    }
}
