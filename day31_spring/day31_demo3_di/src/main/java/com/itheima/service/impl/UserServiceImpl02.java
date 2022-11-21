package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/*
    使用有参构造的方式完成依赖注入
        一定要提供有参构造！
 */
public class UserServiceImpl02 implements UserService {

    private UserDao userDao;
    private String address;


    public UserServiceImpl02(UserDao userDao, String address) {
        this.userDao = userDao;
        this.address = address;
    }
    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl02的add方法~！"+ address);
        userDao.add();
    }
}
