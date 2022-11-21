package com.itheima.factory;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

public class InstanceFactory {

    public  UserService getBean(){

        System.out.println("调用了InstanceFactory的getBean方法~！");

        return new UserServiceImpl();
    }
}
