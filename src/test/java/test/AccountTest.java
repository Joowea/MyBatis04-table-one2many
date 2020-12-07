package test;

import com.joo.dao.IAccountDao;
import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {

        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.获取sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //3.获取sqlSession对象
        sqlSession = factory.openSession(true);

        //4.获取dao代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws IOException {

        //5.close
        sqlSession.close();
        in.close();
    }

    @Test
    public void testAccountFindAll() {

        List<Account> accounts = accountDao.findAll();

        for (Account account : accounts) {

            System.out.println(account);
        }
    }

    @Test//一对一
    public void testFindAccountAndUser() {

        List<Account> acu = accountDao.findAccountAndUser();

        for (Account a : acu) {
            System.out.println("-----  ------");
            System.out.println(a);
            System.out.println(a.getUser());
        }

    }
}

    /*@Test
    public void testFindAccountAndUser(){

        List<AccountAndUser> acu = accountDao.findAccountAndUser();

        for (AccountAndUser a: acu){

            System.out.println(a);
        }
    }*/


