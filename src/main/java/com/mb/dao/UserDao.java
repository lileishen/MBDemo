package com.mb.dao;

import com.mb.domain.User;

import java.util.List;

/**
 * @author nono
 * @Package com.mb.dao
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2020年08月20日 20:10:00
 */
public interface UserDao {

    public List<User> findAll() throws Exception;

}
