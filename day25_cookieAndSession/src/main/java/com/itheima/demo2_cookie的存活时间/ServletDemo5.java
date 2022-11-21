package com.itheima.demo2_cookie的存活时间;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/10 10:49
 */
@WebServlet("/ServletDemo5")
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //setMaxAge(int seconds)：设置Cookie存活时间
        //正数：将 Cookie写入浏览器所在电脑的硬盘，持久化存储。到时间自动删除
        //负数：默认值，Cookie在当前浏览器内存中，当浏览器关闭，则 Cookie被销毁
        //零：删除对应 Cookie

        // 获取所有cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
            }
        }


        // 创建cookie,封装数据
        Cookie cookie1 = new Cookie("dkey", "ddd");// 默认级别cookie
        Cookie cookie2 = new Cookie("ekey", "eee");// 持久级别的cookie

        // 设置cookie的存活时间
        //cookie2.setMaxAge(60*60*24*7);
        //cookie2.setMaxAge(-2);
        cookie2.setMaxAge(0);

        // 响应cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().write("ServletDemo5...");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
