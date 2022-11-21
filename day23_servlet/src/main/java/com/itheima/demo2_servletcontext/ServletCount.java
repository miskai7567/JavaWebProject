package com.itheima.demo2_servletcontext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/7 17:17
 */
@WebServlet("/ServletCount")
public class ServletCount extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 由于init方法只会执行一次,所以就可以在i                           nit方法中往ServletContext域对象中存储count:0
        getServletContext().setAttribute("count",0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先使用一下乱码处理---明天讲解,今天不用理会
        // 处理请求和响应乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        // 获取ServletContext对象中的count值
        ServletContext servletContext = getServletContext();
        int value = (int)servletContext.getAttribute("count");

        // 自增1
        value++;

        // 把自增后的值更新到ServletContext中
        servletContext.setAttribute("count",value);
        // 显示页面数据
        response.getWriter().println("<h1>Welcome...您是第"+value+"位访问用户</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
