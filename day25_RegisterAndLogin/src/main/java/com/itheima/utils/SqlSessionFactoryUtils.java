package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author pzl
 * @Date 2022/11/8 16:51
 */
public class SqlSessionFactoryUtils {

    // 定义一个SqlSessionFactory成员变量
    private static SqlSessionFactory sqlSessionFactory = null;


    // 静态代码块中创建唯一的SqlSessionFactory对象
    static {
        try {
            // 加载mybatis核心配置文件
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 构建SqlSessionFactory对象
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 提供一个公共的静态方法,获取SqlSessionFactory对象
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    // 提供一个公共的静态方法,获取SqlSession对象
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    // 提供一个静态方法,用来释放资源
    // 关闭SqlSession
    public static void closeSqlSession(SqlSession sqlSession){
        sqlSession.close();
    }

    // 提交事务并且关闭SqlSession
    public static void closeSqlSessionAndCommit(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }


}
