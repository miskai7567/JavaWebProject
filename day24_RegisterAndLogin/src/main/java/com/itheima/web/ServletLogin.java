package com.itheima.web;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author pzl
 * @Date 2022/11/8 16:41
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理请求和响应乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 1.获取请求参数---用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.根据用户名和密码去数据库中查询记录,封装成user对象
        /*// 加载mybatis核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();*/

        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();

        // 获取接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 调用方法,执行sql语句
        User user = userDao.findByUsernameAndPassword(username,password);

        // 3.判断user对象是否为null
        if (user == null) {
            // 4.如果为null,说明登录失败,重定向到失败页面
            response.sendRedirect("failed.html");
        }else {
            // 5.如果不为null,说明登录成功
            response.getWriter().write("恭喜您,登录成功!");
        }

        // 释放资源
        //sqlSession.close();
        //is.close();

        SqlSessionFactoryUtils.closeSqlSession(sqlSession);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
