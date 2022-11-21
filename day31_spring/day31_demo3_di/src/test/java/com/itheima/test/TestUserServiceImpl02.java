package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl02 {

    @Test
    public void testAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext02.xml");

        UserService us = (UserService) context.getBean("us");

        us.add();


    }
}
