package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/*
    使用P名称空间来完成依赖注入
        1. 它的背后其实也还是使用set方法实现的。
        2. 只是在xml中配置比较简单而已。
 */
public class UserServiceImpl03 implements UserService {

    private UserDao userDao;
    private String address;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl03的add方法~！"+ address);
        userDao.add();
    }
}
