package com.itheima.demo5_请求转发;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 11:45
 */
@WebServlet("/ServletB")
public class ServletB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发(forward)：一种在服务器内部的资源跳转方式
        System.out.println("ServletB...");
        // 处理请求,响应数据----http://localhost:8080/day24/ServletA?username=zs
        System.out.println(request.getParameter("username"));
        response.getWriter().println("ServletB...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
