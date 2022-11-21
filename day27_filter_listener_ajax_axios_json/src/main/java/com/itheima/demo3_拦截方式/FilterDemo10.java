package com.itheima.demo3_拦截方式;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 10:07
 */
// 过滤ServletDemo10的请求
//@WebFilter(urlPatterns = "/demo10",dispatcherTypes = {DispatcherType.FORWARD})  // 只拦截转发
//@WebFilter(urlPatterns = "/demo10",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})  // 拦截转发,直接请求,重定向
@WebFilter(urlPatterns = "/demo10")  // 只拦截直接请求,重定向
public class FilterDemo10 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       // 放行前的逻辑代码
        System.out.println("FilterDemo10...");
        // 放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
