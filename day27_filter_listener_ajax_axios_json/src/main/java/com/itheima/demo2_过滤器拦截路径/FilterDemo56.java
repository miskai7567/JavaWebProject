package com.itheima.demo2_过滤器拦截路径;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 9:55
 */
//目录拦截：以/开头,以/*结尾,例如: /user/*：访问/user下的所有资源，都会被拦截
@WebFilter("/aa/*")
public class FilterDemo56 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo56...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
