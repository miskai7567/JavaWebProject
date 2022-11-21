package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){

        //ApplicationContext context = new ClassPathXmlApplicationContext();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService us = context.getBean(UserService.class);

        us.add();

    }
}
