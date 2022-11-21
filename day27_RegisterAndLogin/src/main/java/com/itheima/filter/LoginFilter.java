package com.itheima.filter;

import com.itheima.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 10:56
 */
//拦截所有需要登录成功之后才可以访问的资源(jsp,Servlet,html,...)
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 过滤的逻辑代码
        // 0.把请求和响应对象进行向下转型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 1.获取请求资源路径
        String uri = request.getRequestURI();

        // 2.判断请求资源路径是否是需要登录的资源路径
        if (uri.contains("axios") || uri.contains("FindUserServlet") || uri.contains("ServletCheckCode") || uri.contains("ServletLogin") || uri.contains("ServletRegister") || uri.contains("register.html") || uri.contains("login")) {
            // 2.1 如果不是需要登录就可以访问的资源,就直接放行
            chain.doFilter(request, response);
        } else {
            // 2.2 如果是需要登录才可以访问的资源,就需要进行权限校验
            // 2.3 判断是否登录了---判断session域对象中是否有user
            User user = (User) request.getSession().getAttribute("user");

            if (user != null) {
                // 2.3.1 如果登录了,就放行
                chain.doFilter(request,response);
            }else {
                // 2.3.2 如果没有登录,就不放行
                System.out.println("小子,你还没登录呢!");
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
