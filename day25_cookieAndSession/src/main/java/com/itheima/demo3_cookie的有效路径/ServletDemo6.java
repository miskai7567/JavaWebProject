package com.itheima.demo3_cookie的有效路径;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/10 11:06
 */
@WebServlet("/demo6")
public class ServletDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 默认路径
        // 创建Cookie对象,封装数据
        Cookie cookie = new Cookie("fkey", "fff");

        // 响应cookie
        response.addCookie(cookie);
        response.getWriter().write("ServletDemo6...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
