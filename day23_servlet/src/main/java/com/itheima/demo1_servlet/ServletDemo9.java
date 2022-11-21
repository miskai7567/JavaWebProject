package com.itheima.demo1_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/7 15:58
 */
// 任意路径匹配: /   -----jsp资源可以正常访问到,但html,css,js等静态资源访问不了了
//    扩展: jsp---本质是Servlet---jsp在运行的时候会翻译成Servlet
    /*
        / 和 /* 区别：
            当我们的项目中的Servlet配置了“/”，会覆盖掉tomcat中的DefaultServlet，当其他的 url-pattern都匹配不上时都会走这个Servlet
            当我们的项目中配置了“/*”，意味着匹配任意访问路径

            eg: 访问jsp页面---jsp会翻译成Servlet---访问路径---匹配----可以访问

     */
    //@WebServlet("/")
public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo9...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
