package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
   IOC的注解解释：
        @Component:
            作用： 用来告诉spring要创建这个类的对象！
            属性：
                value: 用来设置对象的id值，如果不设置，那么默认采用首字母小写的类名作为id值
            @Controller: 针对web层
            @Service: 针对service层
            @Repository: 针对dao层

        @Scope:
            作用： 用来配置单例或者多例
            属性：
                value： 配置单例 【singleton】 或者多例 【prototype】
        @PostConstruct:
            作用： 打在方法上，初始化对象的时候调用该方法
        @PreDestroy ：
            作用：打在方法上，销毁对象的时候调用该方法
 */
//@Component("us")

@Scope("prototype")
@Service("us")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoImpl;

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~！");
        userDaoImpl.add();
    }

    @PostConstruct
    public void init(){
        System.out.println("调用了UserServiceImpl的init方法~！");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("调用了UserServiceImpl的destroy方法~！");
    }
}
