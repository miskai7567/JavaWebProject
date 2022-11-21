package com.itheima.demo3_拦截方式;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 10:06
 */
@WebServlet("/demo9")
public class ServletDemo9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo9...");
        // 转发到ServletDemo10
        request.getRequestDispatcher("demo10").forward(request,response);
        // 重定向
        //response.sendRedirect(request.getContextPath() + "/demo10");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
