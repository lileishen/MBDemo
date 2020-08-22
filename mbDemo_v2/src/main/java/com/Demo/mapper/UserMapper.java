package com.Demo.mapper;

import com.Demo.domain.Role;
import com.Demo.domain.User;

import java.util.List;

/**
 * @author nono
 * @Package com.Demo.mapper
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年08月21日 08:10:00
 */
public interface UserMapper {

    public void  insert(User user);

    public User findById(Integer id);

    public List<User>  findAll();

    public List<User> findAllOrder();

    public List<User>  findUserAndRole();

}
