package com.itheima.web;

import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/14 15:07
 */
@WebServlet("/deleteBrand")
public class DeleteBrandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteBrand...");
        // 1.获取请求参数----id
        int id = Integer.parseInt(request.getParameter("id"));

        // 2.调用service层,根据id删除记录
        BrandService brandService = new BrandService();
        int rows = brandService.deleteBrand(id);

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
