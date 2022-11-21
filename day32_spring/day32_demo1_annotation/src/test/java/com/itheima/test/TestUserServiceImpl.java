package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService us = context.getBean(UserServiceImpl.class);

        us.add();
    }

}
