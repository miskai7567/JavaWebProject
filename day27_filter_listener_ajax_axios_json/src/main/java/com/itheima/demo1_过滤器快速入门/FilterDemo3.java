package com.itheima.demo1_过滤器快速入门;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 9:33
 */
@WebFilter("/demo3")
public class FilterDemo3 implements Filter {
    public void destroy() {
        System.out.println("FilterDemo3 destroy...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo3 doFilter...");
        // 放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterDemo3 init...");
    }

}
