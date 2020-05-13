import com.ni.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class jdbcTest {
    @Autowired
    private JdbcTemplate template;

    @Test
    public void testJdbc() {

//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql:///spring?useSSL=false");
//        ds.setUsername("root");
//        ds.setPassword("12345");
//        JdbcTemplate template = new JdbcTemplate(); //构造函数也有带数据源的
//        template.setDataSource(ds);
        template.execute("insert into account(name,money) values('eee',1000)");
    }

    @Test
    public void crud_save() {
        template.update("insert into account(name,money) values(?,?)","fff",1000f);
    }

    @Test
    public void crud_update(){
        template.update("update account set name=?,money=? where id=?","ffff",800,9);
    }

    @Test
    public void crud_delete(){
        template.update("delete from account where id=?",9);
    }

    @Test
    public void crud_getAll(){
        List<Account> list = template.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        for (Account a:list)
            System.out.println(a);
    }

    @Test
    public void crud_getById() {
        List<Account> list = template.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),100);
        if (!list.isEmpty())
            System.out.println(list.get(0));
    }

    //查询返回一行一列 （聚合函数不加group by）
    @Test
    public void crud_getCount(){
        int ct = template.queryForObject("select count(*) from account where money>?",Integer.class,1000f);
        System.out.println(ct);
    }
}
