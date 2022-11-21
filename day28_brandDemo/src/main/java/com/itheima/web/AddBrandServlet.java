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
 * @Date 2022/11/14 14:49
 */
@WebServlet("/addBrand")
public class AddBrandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addBrand...");
        // 1.获取请求参数--json
        Brand brand = JSON.parseObject(request.getInputStream(), Brand.class);

        // 2.调用service层,进行添加数据
        BrandService brandService = new BrandService();
        int rows = brandService.addBrand(brand);

        // 3.响应成功标识
        if (rows > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
