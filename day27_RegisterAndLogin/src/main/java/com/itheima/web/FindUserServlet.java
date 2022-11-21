package com.itheima.web;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 14:38
 */
@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FindUserServlet...");

        // 1.获取请求参数--用户名
        String username = request.getParameter("username");

        // 2.获取sqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();

        // 3.获取接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // 4.调用方法,执行sql语句
        User user = userDao.findByUsername(username);

        // 5.判断,响应标识给浏览器
        if (user == null){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
