package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApplicationContext {
    @Test
    public void testGetBeanNames(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext07.xml");

        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println("name = " + name);
        }


    }

    @Test
    public void testGetBean(){


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext07.xml");

        //1. 使用id来拿对象
        //UserService  us = (UserService) context.getBean("us");

        //2. 使用id来拿对象，使用类型来约束它
        //UserService us = context.getBean("us", UserService.class);

        //3. 使用类型来拿对象，使用实现类的类型来拿对象
        UserService us = context.getBean(UserServiceImpl.class);

        //使用接口类型来拿对象，也是可以的，但是有一个隐患：如果有多个实现类对象，那么就不知道要返回谁！
        //UserService us = context.getBean(UserService.class);

        us.add();


    }
}
