package com.mb.Service.ServiceImpl;

import com.mb.Service.UserService;
import com.mb.dao.DaoImpl.UserDaoImpl;
import com.mb.dao.UserDao;
import com.mb.domain.User;

import java.util.List;

/**
 * @author nono
 * @Package com.mb.Service.ServiceImpl
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年08月20日 23:13:00
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() throws Exception {
        UserDao userDao =new UserDaoImpl();

        return userDao.findAll();

    }
}
