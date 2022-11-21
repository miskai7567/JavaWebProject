package com.itheima.demo1_过滤器快速入门;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 9:27
 */
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo2...");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
