package com.itheima.demo7_操作响应头;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 14:41
 */
@WebServlet("/ServletDemo10")
public class ServletDemo10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo10....");
        // 定时刷新\跳转
        //response.setHeader("Refresh","5;url=http://www.itheima.com");
        response.setHeader("Refresh","5;url=http://localhost:8080/day24/ServletDemo10");
        //response.setHeader("Refresh","5;url=ServletDemo10");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
