package com.itheima.test;

import com.itheima.bean.User;
import com.itheima.config.AppConfig;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class TestUserServiceImpl {

    @Test
    public void testFindAll() throws IOException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService us = context.getBean(UserService.class);

        List<User> list = us.findAll();

        System.out.println("list = " + list);

    }

}
