package com.itheima.web2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author pzl
 * @Date 2022/11/15 15:57
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException{}
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException{}
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{}
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{}
}
