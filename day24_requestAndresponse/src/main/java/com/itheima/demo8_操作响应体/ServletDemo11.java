package com.itheima.demo8_操作响应体;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 14:49
 */
@WebServlet("/ServletDemo11")
public class ServletDemo11 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 操作响应体
        // 页面输出只能使用其中的一个流实现,两个流是互斥的.
        // 流可以写文本,也可以写HTML代码
        //response.getOutputStream().write("响应体".getBytes());// 乱码
        //response.getOutputStream().println("ServletDemo11...响应体");// 报错
        //response.getOutputStream().println("<h1>ServletDemo11...</h1>");// 报错

        //response.getWriter().println("<h1>ServletDemo11...</h1>");
        //response.getWriter().println("<h1>ServletDemo11...响应体</h1>");// 乱码
        //response.getWriter().write("<h1>ServletDemo11...响应体</h1>");// 乱码

        // 解决字节输出流乱码问题
        // 1.设置浏览器解析的编码
        //response.setHeader("Content-Type","text/html;charset=utf-8");
        // 2.指定编码写数据
        //response.getOutputStream().write("响应体".getBytes("utf-8"));


        // 解决字符输出流乱码问题
        // 方式一:
        /*// 1.设置响应对象的编码
        response.setCharacterEncoding("utf-8");

        // 2.设置浏览器解析的编码
        response.setHeader("Content-Type","text/html;charset=utf-8");*/

        // 方式二:
        response.setContentType("text/html;charset=utf-8");

        // 3.写数据
        //response.getWriter().write("响应体...");
        response.getOutputStream().write("响应体...".getBytes());


        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
