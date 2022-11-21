package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService us = con.getBean(UserService.class);

        us.add();
    }
}
