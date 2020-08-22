import com.Demo.domain.Order;
import com.Demo.domain.User;
import com.Demo.mapper.OrderMapper;
import com.Demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

/**
 * @author nono
 * @Package PACKAGE_NAME
 * @ClassName Demotest.java
 * @Description TODO
 * @createTime 2020年08月21日 08:07:00
 */
public class DemoTest {

    @Test
    public void insert(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build =  new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(0, "admin", "admin",new Date());
            mapper.insert(user);
            sqlSession.commit();
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
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.findById(6);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            /**
             * 设置的当前页和显示条数
             */
            PageHelper.startPage(0,1);

            List<User> users = userMapper.findAll();
            for (User user : users) {
                System.out.println(user);
            }
            PageInfo<User> pageInfo =new PageInfo<>(users);
            System.out.println(pageInfo.getPageNum());
            System.out.println(pageInfo.getPages());
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订单的关联查询
     */

    @Test
    public void test(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            List<Order> orders = mapper.findOrders();
            for (Order order : orders) {
                System.out.println(order);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> allOrder = mapper.findAllOrder();
            for (User user : allOrder) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> allOrder = mapper.findUserAndRole();
            for (User user : allOrder) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
