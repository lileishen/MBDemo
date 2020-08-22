package com.mb.Service;

import com.mb.domain.User;

import java.util.List;

/**
 * @author nono
 * @Package com.mb.Service
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年08月20日 23:11:00
 */
public interface UserService {

    public List<User> findAll() throws Exception;
}
