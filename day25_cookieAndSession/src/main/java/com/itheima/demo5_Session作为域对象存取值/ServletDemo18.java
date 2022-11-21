package com.itheima.demo5_Session作为域对象存取值;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/10 12:25
 */
@WebServlet("/ServletDemo18")
public class ServletDemo18 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 取值
        // 获取session对象
        HttpSession session = request.getSession();// 如果服务器有session对象,就获取,如果没有,就创建

        // 从session对象中取值
        Object value = session.getAttribute("akey");

        // 响应数据到页面
        response.getWriter().write("ServletDemo18..."+value+","+ session.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
