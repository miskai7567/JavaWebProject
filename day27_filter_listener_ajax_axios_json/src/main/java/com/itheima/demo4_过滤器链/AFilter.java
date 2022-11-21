package com.itheima.demo4_过滤器链;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 10:25
 */
//@WebFilter("/*")
public class AFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("AFilter...放行前的逻辑代码...");
        // 放行
        chain.doFilter(req, resp);
        System.out.println("AFilter...放行后的逻辑代码...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
