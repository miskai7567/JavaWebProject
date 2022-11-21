package com.itheima.demo5_请求转发;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 11:45
 */
@WebServlet("/ServletA")
public class ServletA extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发(forward)：一种在服务器内部的资源跳转方式
        // 请求转发到ServletB
       /* System.out.println("ServletA接受到请求之后,转发给ServletB...");
        request.getRequestDispatcher("ServletB").forward(request,response);*/


        // 请求转发的特点:
        //请求转发的路径只能写相对路径,不能写绝对路径---会报404错误
        //request.getRequestDispatcher("http://localhost:8080/day24/ServletB").forward(request,response);
        //request.getRequestDispatcher("/day24/ServletB").forward(request,response);

        //请求转发地址栏请求路径不会变
        //请求转发只有1次请求
        //请求转发只能转发到本项目中的资源,不能转发到外部项目资源
        //request.getRequestDispatcher("http://www.itheima.com").forward(request,response);

        //可以转发到WEB-INF里面的资源---一般不建议把资源放在WEB-INF里面
        request.getRequestDispatcher("WEB-INF/b.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
