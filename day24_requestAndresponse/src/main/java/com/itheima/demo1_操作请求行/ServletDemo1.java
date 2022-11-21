package com.itheima.demo1_操作请求行;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 9:35
 */
@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 操作请求行
        //#### 获取客户机信息(操作请求行): 请求方式  请求路径(URI)  协议版本
        //- **getMethod()**;获取请求方式
        System.out.println("获取请求方式:  " + request.getMethod());

        //- **getRemoteAddr()** ；获取客户机的IP地址(知道是谁请求的)
        System.out.println("获取客户机的IP地址: " + request.getRemoteAddr());

        //- **getContextPath()**;获得当前应用工程名(部署的路径); **重点**
        System.out.println("获取项目的部署路径: " + request.getContextPath());

        //- **getRequestURI();获得请求地址，不带主机名**
        System.out.println("获得请求地址，不带主机名: " + request.getRequestURI());

        //- **getRequestURL()；获得请求地址，带主机名**
        System.out.println("获得请求地址，带主机名: " + request.getRequestURL());

        //- getServerPort()；获得服务端的端口
        System.out.println("获得服务端的端口: " + request.getServerPort());

        //- getQueryString()；获的请求参数(get请求的,URL的?后面的)
        System.out.println("获的请求参数: " + request.getQueryString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
