package com.itheima.demo1_servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/7 14:34
 */
public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo2 init...");
        // ServletConfig: 获取当前Servlet的初始化参数
        String value = servletConfig.getInitParameter("akey");
        System.out.println(value);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("只有访问当前Servlet就会执行该service方法...ServletDemo2");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
