package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<User> findAll() throws IOException {
        return userDao.findAll();
    }
}
