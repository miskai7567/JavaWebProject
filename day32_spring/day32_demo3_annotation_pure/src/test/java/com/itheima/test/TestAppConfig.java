package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAppConfig {

    @Test
    public void testShow(){

        //ApplicationContext context = new ClassPathXmlApplicationContext();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig config = context.getBean(AppConfig.class);

        config.show();

    }
    @Test
    public void testNames(){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println("name = " + name);
        }

    }
}
