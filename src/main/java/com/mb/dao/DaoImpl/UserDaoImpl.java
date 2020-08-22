package com.mb.dao.DaoImpl;

import com.mb.dao.UserDao;
import com.mb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author nono
 * @Package com.mb.dao.DaoImpl
 * @ClassName UserDaoImpl.java
 * @Description TODO
 * @createTime 2020年08月20日 23:04:00
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession();
        List<User> users = sqlSession.selectList("usermapper.findAll");
        return users;
    }
}
