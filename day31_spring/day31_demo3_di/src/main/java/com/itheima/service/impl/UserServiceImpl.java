package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/*
    使用set方法来完成依赖注入！
        1. 定义属性
        2. 提供属性的set方法
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！"+ address);
        userDao.add();
    }
}
