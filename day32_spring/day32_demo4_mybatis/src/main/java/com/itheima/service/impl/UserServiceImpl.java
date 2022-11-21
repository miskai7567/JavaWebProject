package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl  implements UserService {


    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<User> findAll() throws IOException {

        //1. 读取核心配置文件成输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 构建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //3. 构建SqlSessionFactory
        SqlSessionFactory sessionFactory = builder.build(is);

        //4. 构建SqlSession
        SqlSession sqlSession = sessionFactory.openSession();

        //5. 获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        //6. 调用方法
        List<User> list = userDao.findAll();

        //7. 关闭SqlSession
        sqlSession.close();

        return list;
    }
}
