package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl02 {

    @Test
    public void testAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService us = (UserService) context.getBean("us02");

        us.add();
    }

}
