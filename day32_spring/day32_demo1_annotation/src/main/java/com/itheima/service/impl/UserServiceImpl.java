package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    注解实现IOC和DI：
        需求：
            在UserServiceImpl里面调用UserDaoImpl的add方法~
        实现：
            1. 需要把UserServiceImpl 和 UserDaoImpl 类交给spring管理
                1.1 昨天：
                    <bean id="" class=""/>
                    <bean id="" class=""/>
                1.2 只要在两个类上面打注解 ：
                    @Component

            2. 让spring把UserDaoImpl的对象注入到UserServiceImpl里面来
                2.1 昨天：
                    a. 定义属性
                    b. 提供属性的set方法 |  有参构造函数
                2.2 今天：
                    a. 定义属性
                    b. 在属性上打注解 @Autowired
            3. 由于我们把IOC和DI的配置都换成了注解的方式来写，所以在applicationContext.xml里面
                不用写这些配置了。
 */

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！");
        userDao.add();
    }
}
