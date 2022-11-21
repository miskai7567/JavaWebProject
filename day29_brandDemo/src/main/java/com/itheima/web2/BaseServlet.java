package com.itheima.web2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author pzl
 * @Date 2022/11/15 16:00
 */
// 不需要配置路径----它就是来当爹的---给其他Servlet继承的
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求路径uri
        String uri = request.getRequestURI();

        // 2.截取最后一个/后面的内容
        int index = uri.lastIndexOf("/");
        String methodName = uri.substring(index + 1);

        // 使用反射根据方法名获取方法,然后使用反射调用方法
        try {
            // this是子类Servlet对象
            System.out.println("this = " + this.getClass());
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求路径uri
        String uri = request.getRequestURI();

        // 2.截取最后一个/后面的内容
        int index = uri.lastIndexOf("/");
        String methodName = uri.substring(index + 1);

        // 3.判断最后一个/后面的内容
        *//*if ("selectAll".equals(methodName)){
            // 调用selectAll()方法
            selectAll(request,response);
        }else if ("addBrand".equals(methodName)){
            // 调用addBrand()方法
            addBrand(request,response);
        }else if ("updateBrand".equals(methodName)){
            // 调用updateBrand()方法
        }else if ("deleteBrand".equals(methodName)){
            // 调用deleteBrand()方法
        }*//*

        // 使用反射根据方法名获取方法,然后使用反射调用方法
        try {
            // this是子类Servlet对象
            System.out.println("this = " + this.getClass());
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }*/
}
