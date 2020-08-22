import com.mb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author nono
 * @Package PACKAGE_NAME
 * @ClassName MybaitsTest.java
 * @Description TODO
 * @createTime 2020年08月20日 20:20:00
 */
public class MybaitsTest {

    @Test
    public void selecct() {
        //加载核心配置文件
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //获得session 工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //sqlSession获得会话对象
            SqlSession sqlSession = build.openSession();
            //执行操作 参数 namespace +id
            List<User> users = sqlSession.selectList("usermapper.findAll");
            System.out.println(users);
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        try {
            //获取核心配置文件
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建session工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //获得session会话对象
            SqlSession sqlSession = build.openSession();
            //执行操作
            User user = new User(0, "root", "root");
            sqlSession.insert("usermapper.save", user);
            //提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        try {
            User user = new User(0, "root", "123456");
            //加载核心配置文件
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建sqlSession 工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //创建sqlSession会话对象
            SqlSession sqlSession = build.openSession();
            //执行
            sqlSession.update("usermapper.updateByUsername", user);
            //sqlsession提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void delete() {
        try {
            //获得核心配置资源
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            sqlSession.delete("usermapper.deleteById",1);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void findById(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            User user = sqlSession.selectOne("usermapper.findOneByid", 4);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
