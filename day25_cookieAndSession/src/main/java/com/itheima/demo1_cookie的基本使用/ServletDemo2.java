package com.itheima.demo1_cookie的基本使用;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/10 9:57
 */
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo2...");

        // 获取浏览器携带过来的cookie
        Cookie[] cookies = request.getCookies();

        // 循环遍历所以的cookie
        if (cookies != null){
            for (Cookie cookie : cookies) {
                // 获取当前cookie的键和值
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + ":" + value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
