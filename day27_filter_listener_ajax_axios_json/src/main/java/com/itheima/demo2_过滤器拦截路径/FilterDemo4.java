package com.itheima.demo2_过滤器拦截路径;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 9:55
 */
//拦截具体的资源：以/开头的完整路径,例如: /index.jsp：只有访问index.jsp时才会被拦截
@WebFilter("/demo4")
public class FilterDemo4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo4...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
