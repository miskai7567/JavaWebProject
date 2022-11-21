package com.itheima.factory;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

public class StaticFactory {

    public static UserService getBean(){

        System.out.println("调用了StaticFactory的getBean方法~！");

        return new UserServiceImpl();
    }
}
