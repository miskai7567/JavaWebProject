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
 * @Date 2022/11/14 15:54
 */
@WebServlet("/updateBrand")
public class UpdateBrandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateBrand...");
        // 1.接收参数----json格式
        Brand brand = JSON.parseObject(request.getInputStream(), Brand.class);
        System.out.println("brand = " + brand);

        // 2.调用service层,修改记录
        BrandService brandService = new BrandService();
        int rows = brandService.updateBrand(brand);

        // 3.响应标识
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
