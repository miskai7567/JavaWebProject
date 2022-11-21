package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.UserService;

/*
    DI ：
        1. 把UserDaoImpl交给spring管理，让它创建对象！
            <bean id="" class=""/>
        2. 在UserServiceImpl当中定义UserDao的属性, 方便一会接收spring给过来的UserDaoImpl的对象！
            private UserDao userDao;
            private UserDaoImpl userDaoImpl;
        3. 定义属性的set方法，然后在xml当中配置，告诉spring要通过set方法来完成依赖注入！
 */
public class UserServiceImpl implements UserService {

    //定义属性
    private UserDao userDao;

    //提供属性的set方法
    public void setUserDao(UserDao userDao) {
        System.out.println("来调用set方法赋值~！");
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！");

        //传统方式调用dao
        //UserDao userDao = new UserDaoImpl();
        userDao.add();

    }
}
