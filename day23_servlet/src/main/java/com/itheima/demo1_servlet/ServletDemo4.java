package com.itheima.demo1_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/7 15:25
 */
@WebServlet("/demo4")
public class ServletDemo4 extends HttpServlet {

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo4 service...");

        // 获取请求方式
        String method = req.getMethod();
        // 判断请求方式
        if ("GET".equals(method)){
            // 处理get请求的代码
        }else if ("POST".equals(method)){
            // 处理post请求的代码
        }
        //...
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果是get请求,就会执行doGet方法---因为访问当前Servlet就会调用service方法,而使用的service方法使用的是父类的,父类的service方法里面对请求方式进行了判断,如果是get请求,就会执行doGet方法
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果是post,就会执行doPost方法---因为访问当前Servlet就会调用service方法,而使用的service方法使用的是父类的,父类的service方法里面对请求方式进行了判断,如果是post请求,就会执行doPost方法
        System.out.println("doPost...");

    }


}
