package com.itheima.test;

import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccountServiceImpl {

    @Test
    public void testTransfer(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService as = context.getBean(AccountService.class);

        as.transfer("zs" , "ls" , 100);

    }

}
