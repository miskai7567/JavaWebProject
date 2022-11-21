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
import javax.servlet.http.Cookie;
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
        // 获取用户输入的验证码
        String inputCheckCode = request.getParameter("checkcode");
        System.out.println("inputCheckCode = " + inputCheckCode);

        // 校验验证码---session域对象中存储的验证码和用户输入的验证码是否一致
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        if (!inputCheckCode.equalsIgnoreCase(checkCode)){
            // 输入的验证码和生成的验证码不一致
            response.getWriter().write("验证码有误!");

            // 验证码错误,直接结束方法--不需要根据用户名和密码查询了
            return;
        }


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
            // 记住用户名
            // 1.获取记住用户名复选框的值
            String remember = request.getParameter("remember");

            // 2.判断该值是否等于true
            if ("true".equals(remember)) {
                // 3.如果等于true,说明用户勾选了记住用户名复选框---创建cookie保存用户名
                // 3.1 创建Cookie对象,保存用户名
                Cookie cookie = new Cookie("username", username);
                // 3.2 设置cookie的存活时间
                cookie.setMaxAge(60*60*24*7);
                // 3.3 设置cookie的有效路径
                cookie.setPath(request.getContextPath());
                // 3.4 响应cookie
                response.addCookie(cookie);

            }else {
                // 3.如果不等于true,说明用户没有勾选记住用户名复选框---删除cookie
                // 3.1 创建Cookie对象,保存用户名
                Cookie cookie = new Cookie("username", "");
                // 3.2 设置cookie的存活时间
                cookie.setMaxAge(0);
                // 3.3 设置cookie的有效路径
                cookie.setPath(request.getContextPath());
                // 3.4 响应cookie
                response.addCookie(cookie);
            }

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
