package com.itheima.service.impl;

import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！");
    }


    public UserServiceImpl(){
        System.out.println("调用了UserServiceImpl的无参构造方法");
    }

    public void init(){
        System.out.println("调用了UserServiceImpl的init方法~！");
    }

    public void destroy(){
        System.out.println("调用了UserServiceImpl的destroy方法~！");
    }
}
