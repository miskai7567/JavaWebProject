package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl05 {

    @Test
    public void testAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext05.xml");

        UserService us = (UserService) context.getBean("us");

        us.add();


    }

    @Test
    public void test(){
        ApplicationContext context1=new ClassPathXmlApplicationContext("testApplicationContext.xml");
        UserService abc=(UserService) context1.getBean("abc");
        abc.add();
    }
}
