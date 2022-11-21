package com.itheima.demo6_session对象的销毁;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/10 14:31
 */
@WebServlet("/ServletDemo20")
public class ServletDemo20 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = request.getSession();

        // 获取sessionid
        String sessionId = session.getId();

        // 往session对象中存值
        session.setAttribute("akey","aaa");

        // cookie设置为持久级别
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setMaxAge(60*60*24*7);
        cookie.setPath(request.getContextPath()+"/");

        // 响应cookie给浏览器
        response.addCookie(cookie);

        // 响应数据到页面
        response.getWriter().write("ServletDemo20..."+sessionId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
