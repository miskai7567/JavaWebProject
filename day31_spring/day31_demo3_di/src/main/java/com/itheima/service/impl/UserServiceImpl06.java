package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

import java.util.*;

/*
    注入集合数据类型
 */
public class UserServiceImpl06 implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private String [] array;
    private List<String> list;
    private Set<String> set;
    private Map<String , String> map;
    private Properties properties;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl04的add方法~！");
        userDao.add();

        System.out.println("array = " + Arrays.toString(array));
        System.out.println("list = " + list);
        System.out.println("set = " + set);
        System.out.println("map = " + map);
        System.out.println("properties = " + properties);
    }
}
