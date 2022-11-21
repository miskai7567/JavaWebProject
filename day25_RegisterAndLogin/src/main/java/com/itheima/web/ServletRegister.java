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
 * @Date 2022/11/8 16:13
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletRegister....");
        // 处理请求和响应乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 1.获取表单提交的数据---用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.根据用户名去数据库中查询记录,封装为User对象
        /*// 加载mybatis核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();*/
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        // 获取接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 调用方法,执行sql语句
        User user = userDao.findByUsername(username);

        // 3.判断user对象是否为null
        if (user == null) {
            // 4.如果为null,用户名可用-----注册
            userDao.add(username,password);
            // 注册成功,跳转到成功页面
            //response.sendRedirect("/day/success.html");
            response.sendRedirect("/day/login.html");
        }else {
            // 5.如果不为null,用户名不可用---返回提示信息: 用户名已存在
            response.getWriter().write("用户名已存在!");
        }

        // 提交事务,释放资源
        //sqlSession.commit();
        sqlSession.close();
        //is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
