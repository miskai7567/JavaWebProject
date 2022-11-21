package com.itheima.demo2_过滤器拦截路径;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 9:59
 */
//拦截所有：/*：访问所有资源，都会被拦截
//@WebFilter("/*")
public class FilterDemo8 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo8...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
