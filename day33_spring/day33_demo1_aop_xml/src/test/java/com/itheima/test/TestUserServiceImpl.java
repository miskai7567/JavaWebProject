package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService us = context.getBean(UserService.class);

        us.add();
    }
    @Test
    public void testUpdate(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService us = context.getBean(UserService.class);

        us.update();
    }
}
