package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){

        //1. 创建工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 问工厂要对象
        UserService us = (UserService) context.getBean("us");

        //3. 调用方法
        us.add();


    }
}
