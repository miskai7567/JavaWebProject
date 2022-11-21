package com.itheima.demo6_请求域对象;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 11:59
 */
@WebServlet("/ServletDemo7")
public class ServletDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求域对象中移除数据---没有意义
        System.out.println("ServletDemo7...从请求域对象中移除数据");
        request.removeAttribute("akey");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
