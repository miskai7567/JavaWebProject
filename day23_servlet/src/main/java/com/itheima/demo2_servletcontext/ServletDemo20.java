package com.itheima.demo2_servletcontext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author pzl
 * @Date 2022/11/7 17:04
 */
@WebServlet("/demo20")
public class ServletDemo20 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // + String  getRealPath(String path);根据资源名称得到资源的绝对路径,默认到了webapp下.
        String realPath = getServletContext().getRealPath("c.txt");
        System.out.println("realPath = " + realPath);
        // 服务器插件运行:realPath = D:\workspace\day23_servlet\src\main\webapp\c.txt
        // tomcat软件运行:realPath = D:\workspace\szitheima136\out\artifacts\day23_servlet_war_exploded\c.txt

        //   + **InputStream getResourceAsStream(String path) ;返回制定路径文件的流,默认到webapp下**
        InputStream is = getServletContext().getResourceAsStream("c.txt");
        System.out.println("is.read() = " + is.read());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
