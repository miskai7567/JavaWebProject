package com.itheima.web;

import com.itheima.bean.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/11 14:38
 */
@WebServlet("/findAll")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建BrandService对象
        BrandService brandService = new BrandService();

        // 调用BrandService中的findAll方法---查询所有记录
        List<Brand> list = brandService.findAll();

        // 把查询出来的记录存储到请求域对象中
        request.setAttribute("list",list);

        // 转发到brand.jsp
        request.getRequestDispatcher("brand.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
