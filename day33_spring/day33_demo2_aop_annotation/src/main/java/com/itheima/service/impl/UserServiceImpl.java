package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！");
    }

    @Override
    public void update() {
        System.out.println("调用了UserServiceImpl的update方法~！");
    }
}
