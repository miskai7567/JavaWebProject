package com.itheima.dao;

import com.itheima.bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
