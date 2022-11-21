package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("us02")
public class UserServiceImpl02 implements UserService {

    /*
        DI的注解解释：
            @Autowired: 自动注入
                1. 按照属性的类型去IOC容器里面找匹配的对象，如果找到只有一个对象匹配这种类型，那么就注入！
                2. 如果在IOC容器中有多个对象匹配属性的类型，会拿着属性的名字，当成是id值，继续去匹配
                    2.1 如果找到了哪个对象的id值正好就是这个属性的名字，那么就注入它
                    2.2 否则就报错！

                     @Autowired
                     private UserDao abc;

              @Qualifier：
                 1. 不能单独使用，需要搭配@Autowired一起使用
                 2. 用来告诉@Autowired，使用什么名字的id去找对象注入

              @Resource:
                 1. 等价于 @Autowired + @Qualifier
                 2. 使用名字去找对象注入
     */
    /*@Autowired
    private UserDao abc;*/


    //@Qualifier("userDaoImpl")
    //@Autowired
    //private UserDao userDao;


    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    @Value("北京")
    private String address;

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;


    @Override
    public void add() {
        System.out.println("driverClassName = " + driverClassName);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        System.out.println("调用了UserServiceImpl02的add方法~！" + address);
        //abc.add();
        userDao.add();
    }
}
