package com.itheima.demo4_记录用户各自的上次访问时间;

import com.itheima.uitls.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author pzl
 * @Date 2022/11/10 11:42
 */
@WebServlet("/ServletDemo161")
public class ServletDemo161 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理请求和响应乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 1.获取浏览器携带过来的所有cookie
        Cookie[] cookies = request.getCookies();

        // 2.查找目标cookie(存有上一次访问时间的cookie
        Cookie lastTimeCookie = CookieUtils.getCookie("lastTime", cookies);

        // 3.如果没有目标cookie,说明是第一次访问
        if (lastTimeCookie == null) {
            // 3.1 获取当前系统时间
            Date nowDate = new Date();
            long time = nowDate.getTime();

            // 3.2 创建cookie对象(lastTime),封装当前系统时间
            Cookie cookie = new Cookie("lastTime", time + "");

            // 3.3 设置cookie的存活时间
            cookie.setMaxAge(60*60*24*7);

            // 3.4 设置cookie的有效路径
            cookie.setPath(request.getContextPath());

            // 3.4 响应cookie到浏览器
            response.addCookie(cookie);

            // 3.5 响应信息到页面---欢迎来到本网站,您是一次过来!
            response.getWriter().write("欢迎来到本网站,您是一次过来喔,多多充钱!");
        } else {
            // 4.如果有目标cookie,说明不是第一次访问
            // 4.1 获取目标cookie中的时间---这个时间就是上一次访问的时间
            String lastTimeValue = lastTimeCookie.getValue();

            // 4.2 获取当前系统时间
            Date nowDate = new Date();
            long time = nowDate.getTime();

            // 4.3 创建cookie对象,封装当前系统时间---名称要和第一次访问的时候的cookie名保持一致(cookie的路径一样,键重复,值会覆盖)
            Cookie cookie = new Cookie("lastTime", time + "");

            // 4.4 设置cookie的存活时间
            cookie.setMaxAge(60*60*24*7);

            // 4.5 设置cookie的有效路径---路径要和第一次访问的时候的cookie名保持一致
            cookie.setPath(request.getContextPath());

            // 4.6 响应cookie到浏览器
            response.addCookie(cookie);

            // 4.7 响应信息到页面----上一次访问的时间
            Date date = new Date(Long.parseLong(lastTimeValue));

            response.getWriter().write("您上一次访问的时间是:"+date.toLocaleString());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
