package test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import com.joo.dao.IUserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//测试方法之前执行
    public void init() throws IOException {

        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //3.获取sqlSession对象
        sqlSession = factory.openSession(true);

        //4.获取dao代理对象
        userDao = sqlSession.getMapper(IUserDao.class);

    }

    @After//测试方法之后执行
    public void destroy() throws IOException {

        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        List<User> allUsers = userDao.findAll();

        for(User user:allUsers){

            System.out.println(user);
        }
    }

    @Test
    public void testFindUserAndAccount(){

        List<User> uaa = userDao.findUserAndAccount();

        for (User u:uaa){

            System.out.println("-------------");
            System.out.println(u);
            System.out.println(u.getAccountsList());
        }
    }
}
