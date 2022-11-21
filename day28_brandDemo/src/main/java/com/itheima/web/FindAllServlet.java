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
import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/14 12:04
 */
@WebServlet("/findAll")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FindAllServlet...");
        // 1.调用service层,查询所有记录,得到list集合
        BrandService brandService = new BrandService();
        List<Brand> list = brandService.findAll();

        // 2.把list集合转换为json
        String jsonList = JSON.toJSONString(list);

        System.out.println("jsonList = " + jsonList);

        // 3.响应json数据给前端
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonList);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
