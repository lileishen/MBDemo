package com.Demo.mapper;

import com.Demo.domain.Order;

import java.util.List;

/**
 * @author nono
 * @Package com.Demo.mapper
 * @ClassName OrderMapper.java
 * @Description TODO
 * @createTime 2020年08月21日 10:16:00
 */
public interface OrderMapper {

    public List<Order> findOrders();

}
