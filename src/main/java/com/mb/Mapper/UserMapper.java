package com.mb.Mapper;

import com.mb.domain.User;

import java.util.List;

/**
 * @author nono
 * @Package com.mb.Mapper
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年08月20日 23:29:00
 */
public interface UserMapper {

    public List<User> findAll();

    public User findById(Integer id);

    public void addUser(User user);
}
