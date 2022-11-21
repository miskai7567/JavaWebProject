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
 * @Date 2022/11/7 17:25
 */
@WebServlet("/ServletShow")
public class ServletShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先使用一下乱码处理---明天讲解,今天不用理会
        // 处理请求和响应乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取ServletContext对象中的count值
        ServletContext servletContext = getServletContext();
        int value = (int)servletContext.getAttribute("count");

        // 显示页面数据
        response.getWriter().println("<h1>总共有"+value+"位访问了直播间</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
