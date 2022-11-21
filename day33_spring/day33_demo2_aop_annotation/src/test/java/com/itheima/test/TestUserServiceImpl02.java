package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl02 {

    @Test
    public void testAdd(){
        ApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService us = con.getBean(UserService.class);

        us.add();
    }
}
