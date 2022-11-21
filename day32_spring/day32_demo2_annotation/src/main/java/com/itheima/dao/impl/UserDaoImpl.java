package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("调用了UserDaoImpl的add方法~！");
    }
}
