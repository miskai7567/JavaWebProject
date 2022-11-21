package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){

        //传统的调用方式：
        //UserService us = new UserServiceImpl();
        //us.add();

        //spring的调用方式：
        //1. 创建工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 问工厂要对象
        UserService us = (UserService) context.getBean("us");

        //3. 调用方法
        us.add();

    }

    //测试单例或者多例
    @Test
    public void testAdd02(){
        //spring的调用方式：
        //1. 创建工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 问工厂要对象
        UserService us1 = (UserService) context.getBean("us");
        UserService us2 = (UserService) context.getBean("us");

        System.out.println("us1 = " + us1);
        System.out.println("us2 = " + us2);

    }

    //测试init 和 destroy
    @Test
    public void testAdd03(){
        //spring的调用方式：
        //1. 创建工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 问工厂要对象
        UserService us1 = (UserService) context.getBean("us");
        UserService us2 = (UserService) context.getBean("us");

        //3. 让工厂销毁！
        context.close();/**/

    }
}
