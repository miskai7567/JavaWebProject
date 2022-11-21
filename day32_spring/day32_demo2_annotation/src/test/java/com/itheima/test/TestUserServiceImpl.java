package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //UserService us = context.getBean(UserServiceImpl.class);
        UserService us = (UserService) context.getBean("us");

        us.add();
    }

    //测试单例或者多例
    @Test
    public void testAdd02(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService us1 = context.getBean(UserServiceImpl.class);
        UserService us2 = (UserService) context.getBean("us");

        System.out.println("us1 = " + us1);
        System.out.println("us2 = " + us2);

        context.close();

    }

}
