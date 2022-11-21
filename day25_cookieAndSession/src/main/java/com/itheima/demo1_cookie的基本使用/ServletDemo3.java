package com.itheima.demo1_cookie的基本使用;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author pzl
 * @Date 2022/11/10 9:57
 */
@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo3...");

        // 处理cookie中文问题
        //URLEncode.encode(value,"utf-8");//存入的时候(先通过utf-8编码)
        //URLDecode.decode（value，"utf-8"）;//取出 (通过utf-8解码)

        //--------------------------------获取cookie---------------------------
        // 获取所有cookie
        Cookie[] cookies = request.getCookies();

        // 判断,循环遍历所有cookie
        if (cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(URLDecoder.decode(name,"utf-8") + ":" + value);
            }
        }

        //--------------------------------响应cookie---------------------------

        // 创建Cookie对象,封装数据
        Cookie cookie1 = new Cookie(URLEncoder.encode("中国","utf-8"), "china");
        Cookie cookie2 = new Cookie("ckey", "ccc");

        // 响应cookie到浏览器
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
