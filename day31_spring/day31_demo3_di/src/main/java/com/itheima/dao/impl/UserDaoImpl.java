package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl  implements UserDao {
    @Override
    public void add() {
        System.out.println("调用了UserdaoImpl的add方法~@");
    }
}
