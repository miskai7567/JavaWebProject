package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("abc")
//@Component
public class UserDaoImpl02 implements UserDao {
    @Override
    public void add() {
        System.out.println("调用了UserDaoImpl02的add方法~！");
    }
}
