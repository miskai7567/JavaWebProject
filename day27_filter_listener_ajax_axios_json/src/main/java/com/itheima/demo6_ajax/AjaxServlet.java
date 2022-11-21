package com.itheima.demo6_ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 11:55
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet...");
        // 响应数据
        response.getWriter().write("AjaxServlet...");
        // 上面这句代码同步请求是: 往页面输出字符串
        // 上面这句代码异步请求是: 向ajax传输字符串数据
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
