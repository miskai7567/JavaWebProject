package com.itheima.demo1_servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/7 14:54
 */
// 生命周期第1阶段(加载和实例化):默认是第一次访问当前Servlet,就会创建Servlet对象
//    value和urlPatterns: 用来设置Servlet的访问路径
@WebServlet(value = "/demo3",loadOnStartup = 1,initParams = {@WebInitParam(name="bkey",value="bbb")})
// loadOnStartup
//负整数：第一次被访问时创建Servlet对象
//0或正整数：服务器启动时创建Servlet对象，数字越小优先级越高
public class ServletDemo3 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 生命周期第2阶段(初始化):调用Servlet的init()方法初始化这个对象，完成一些如加载配置文件、创建连接等初始化的工作。该方法只调用一次
        System.out.println("ServletDemo3 init...");
        System.out.println(servletConfig.getInitParameter("bkey"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //  生命周期第3阶段(请求处理):每次请求Servlet时，Servlet容器都会调用Servlet的service()方法对请求进行处理
        System.out.println("service...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        // 生命周期第4阶段(终止):当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法完成资源的释放
        System.out.println("destroy...");
    }
}
