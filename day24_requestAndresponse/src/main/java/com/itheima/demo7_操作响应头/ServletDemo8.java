package com.itheima.demo7_操作响应头;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 12:20
 */
@WebServlet("/ServletDemo8")
public class ServletDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo8...");
        // 重定向方式一:
        //response.setStatus(302);// 设置重定向的状态码
        //response.setHeader("Location","http://www.itheima.com");

        // 重定向方式二:
        response.sendRedirect("http://www.itcast.cn");
        //response.sendRedirect("/day24/a.html");
        //response.sendRedirect("a.html");
        //response.sendRedirect("WEB-INF/b.html");

        //request.setAttribute("dkey","ddd");
        //response.sendRedirect("ServletDemo9");

        // 重定向的特点:
        // 1.重定向是两次请求,两次响应
        // 2.重定向地址栏会变
        // 3. 重定向的路径写绝对路径(带域名/ip地址的, 如果是同一个项目里面的,域名/ip地址可以省略),也可以写相对路径
        // 4. 重定向的路径可以是项目内部的,也可以是项目以外的(eg:百度)
        // 5. 重定向不能重定向到WEB-INF下的资源
        // 6. 把数据存到request里面, 重定向不可用


        // 转发和重定向的区别:
        //1. 转发是一次请求, 重定向是二次请求
        //2. 转发的路径不会改变,重定向的路径会改变
        //3. 转发的路径写相对的(不带http,不带ip,不带部署路径), 重定向的路径写绝对的(带http,带ip,带项目名),重定向到内部项目,可以省略http,ip地址,端口号,也可以写相对路径(不建议)
        //4. 转发只能转发到项目的内部资源,重定向可以重定向到项目的内部资源, 也可以是项目外部资源(eg:百度)
        //5. 转发可以转发到WEB-INF下面的资源, 重定向不可以重定向到WEB-INF下面的资源
        //5. 把数据存到request域对象里面,转发有效, 重定向无效
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
