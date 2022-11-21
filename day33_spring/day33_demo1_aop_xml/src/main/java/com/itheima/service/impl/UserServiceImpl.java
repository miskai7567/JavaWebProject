package com.itheima.service.impl;

import com.itheima.advice.MyAdvice;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！");
        //int a = 1 / 0 ;
    }

    @Override
    public void update() {
        System.out.println("调用了UserServiceImpl的update方法~！");
    }
}
