package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccountServiceImpl02 {

    @Test
    public void testTransfer(){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService as = context.getBean(AccountService.class);

        as.transfer("zs" , "ls" , 100);

    }

}
