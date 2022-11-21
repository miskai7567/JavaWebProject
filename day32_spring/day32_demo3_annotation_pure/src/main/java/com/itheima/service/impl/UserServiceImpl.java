package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Value("${address}")
    private String address;

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！"+address);
        userDao.add();
    }
}
