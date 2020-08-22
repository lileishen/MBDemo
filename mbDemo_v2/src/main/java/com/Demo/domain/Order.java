package com.Demo.domain;

import java.util.Date;

/**
 * @author nono
 * @Package com.Demo.domain
 * @ClassName Orders.java
 * @Description TODO
 * @createTime 2020年08月21日 10:14:00
 */
public class Order {
    private  Integer id;
    private String ordertime;
    private double total;
    //一对一
    private User user;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getordertime() {
        return ordertime;
    }

    public void setordertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(Integer id, String ordertime, double total, User user) {
        this.id = id;
        this.ordertime = ordertime;
        this.total = total;
        this.user = user;
    }
}
