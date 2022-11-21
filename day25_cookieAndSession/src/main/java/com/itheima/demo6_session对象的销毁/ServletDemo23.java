package com.itheima.demo6_session对象的销毁;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/10 14:31
 */
@WebServlet("/ServletDemo23")
public class ServletDemo23 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = request.getSession();

        // 获取sessionid
        String sessionId = session.getId();

        // 销毁session对象
       session.invalidate();

        // 响应数据到页面
        response.getWriter().write("ServletDemo23..." + "sessionID:" + sessionId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
