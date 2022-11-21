package com.itheima.demo2_过滤器拦截路径;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 9:59
 */
//后缀名拦截：不能以/开头,例如: *.jsp：访问后缀名为jsp的资源，都会被拦截
@WebFilter("*.jsp")
public class FilterDemo7 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo7...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
