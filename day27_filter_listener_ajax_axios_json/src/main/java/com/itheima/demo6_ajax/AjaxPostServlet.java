package com.itheima.demo6_ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author pzl
 * @Date 2022/11/12 11:55
 */
@WebServlet("/AjaxpostServlet")
public class AjaxPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxpostServlet...");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "," + password);

        //Map<String, String[]> map = request.getParameterMap();
        //System.out.println("map = " + map);

        //String queryString = request.getQueryString();
        //System.out.println("queryString = " + queryString);

        // 响应数据
        response.getWriter().write("AjaxServlet...");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
