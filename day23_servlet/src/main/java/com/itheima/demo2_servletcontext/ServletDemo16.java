package com.itheima.demo2_servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/7 16:48
 */
@WebServlet("/demo16")
public class ServletDemo16 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo16...");
        // 获取ServletContext对象
        ServletContext servletContext = getServletContext();
        // 从ServletContext对象中取数据
        Object value = servletContext.getAttribute("ckey");
        System.out.println("value = " + value);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
