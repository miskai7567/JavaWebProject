package com.itheima.demo1_cookie的基本使用;

import com.itheima.uitls.CookieUtils;

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
@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo4...");

        // 需求: 获取键名为akey的cookie的值---获取指定名称的cookie
        // 获取浏览器携带过来的所有cookie
        Cookie[] cookies = request.getCookies();

        // 查找指定名称的cookie
        Cookie cookie = CookieUtils.getCookie("akey", cookies);
        System.out.println(cookie.getName() + " = " + cookie.getValue());

       /* // 判断,遍历
        if (cookies != null){
            for (Cookie cookie : cookies) {
                // 判断cookie的键名
                String name = cookie.getName();
                if ("akey".equals(name)){
                    String value = cookie.getValue();
                    System.out.println(name + " = " + value);
                }
            }
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
