package com.example.homework24.web;

import com.example.homework24.bean.User;
import com.example.homework24.dao.UserDao;
import com.example.homework24.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        // 4.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();


        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User byUsername = mapper.findByUsername(username);
        if(byUsername==null) {
            mapper.add(username, password);
            response.sendRedirect("/day/login.html");
        }
        else {
            // 5.如果不为null,用户名不可用---返回提示信息: 用户名已存在
            response.getWriter().write("用户名已存在!");
        }

        SqlSessionFactoryUtils.closeSqlSessionAndCommit(sqlSession);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }
}
