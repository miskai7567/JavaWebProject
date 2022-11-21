package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/*
    Spring整合Junit：
        1.在类上打注解 @RunWith , 指定了测试环境，这个环境是spring对Junit进行了扩展，背后能够创建出来工厂对象
            @RunWith(SpringJUnit4ClassRunner.class)
        2. 在类上打注解 @ContextConfiguration, 用来指定配置文件 |  配置类。
            @ContextConfiguration("classpath:applicationContext.xml")
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = AppConfig.class)
public class TestUserServiceImpl {


    @Autowired
    private UserService us;

    @Test
    public void testAdd(){
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService us = context.getBean(UserService.class);

        us.add();*/

        us.add();
    }
}
