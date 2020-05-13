import com.ni.dao.AccountDao;
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
    private AccountDao accountDao;

    @Test
    public void testJdbc() {
        Account acct = accountDao.findAccountById(1);
        System.out.println(acct);
        acct.setMoney(500f);
        accountDao.updateAccount(acct);
    }

}
