package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl06 {

    @Test
    public void testAdd(){

        //ctrl + h 查看体系结构
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-all.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml", "applicationContext-dao.xml");

        UserService us = (UserService) context.getBean("us");

        us.add();


    }
}
