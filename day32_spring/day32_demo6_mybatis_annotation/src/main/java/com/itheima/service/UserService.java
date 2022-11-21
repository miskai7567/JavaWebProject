package com.itheima.service;

import com.itheima.bean.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll() throws IOException;
}
