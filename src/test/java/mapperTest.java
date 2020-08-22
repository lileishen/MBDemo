import com.mb.Mapper.UserMapper;
import com.mb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author nono
 * @Package PACKAGE_NAME
 * @ClassName mapperTest.java
 * @Description TODO
 * @createTime 2020年08月20日 23:30:00
 */
public class mapperTest {

    @Test
    public void test(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.findAll();
            System.out.println(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test1(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User u = mapper.findById(4);
            System.out.println(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void test2(){
        try {
           // InputStream   is = Resources.getResourceAsStream("SqlMapConfig.xml");
            InputStream is = mapperTest.class.getClassLoader().getSystemResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(0, "admin", "admin");
            user.setBirthday(new Date());
            userMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
