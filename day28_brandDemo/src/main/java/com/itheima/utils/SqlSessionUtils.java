package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author pengzhilin
 * @version 1.0
 */
public class SqlSessionUtils {

    public static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            // 1.读SqlMapConfig.xml核心配置文件,得到字节输入流对象
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

            // 2.创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            // 3.通过SqlSessionFactoryBuilder对象构建SqlSessionFactory对象
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession对象
     * @return
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    /**
     * 提交事务并释放资源
     * @param sqlSession
     */
    public static void commitAndClose(SqlSession sqlSession){
        // 7.提交事务,释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 释放资源
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        // 7.释放资源
        sqlSession.close();
    }


}
