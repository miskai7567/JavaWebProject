package com.itheima.test;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestUserServiceImpl {

    @Test
    public void testFindAll() throws IOException {

        UserService us = new UserServiceImpl();
        List<User> list = us.findAll();
        System.out.println("list = " + list);

    }
}
