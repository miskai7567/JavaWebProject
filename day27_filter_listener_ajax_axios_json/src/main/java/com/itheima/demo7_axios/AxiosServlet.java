package com.itheima.demo7_axios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 14:55
 */
@WebServlet("/AxiosServlet")
public class AxiosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AxiosServlet...");
        // 获取请求参数
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 专门读浏览器传递过来的json字符串数据
        /*BufferedReader reader = request.getReader();
        String line = reader.readLine();
        System.out.println("line = " + line);*/

        // 响应字符串数据
        response.getWriter().write("Hello axios...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
