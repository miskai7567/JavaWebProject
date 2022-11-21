package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.bean.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/14 15:42
 */
@WebServlet("/findBrand")
public class FindBrandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("findBrand....");
        // 1.获取请求参数----id
        int id = Integer.parseInt(request.getParameter("id"));

        // 2.调用service层,根据id查询记录
        BrandService brandService = new BrandService();
        Brand brand = brandService.findBrandById(id);

        // 3.把记录转换为json
        String jsonBrand = JSON.toJSONString(brand);

        // 4.响应json数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonBrand);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
