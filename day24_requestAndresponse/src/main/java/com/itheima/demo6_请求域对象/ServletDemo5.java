package com.itheima.demo6_请求域对象;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 11:59
 */
@WebServlet("/ServletDemo5")
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 往请求域对象中存数据
        System.out.println("ServletDemo5...往请求域对象中存数据");
        request.setAttribute("akey","aaa");

        // 转发到ServletDemo6
        request.getRequestDispatcher("ServletDemo6").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
