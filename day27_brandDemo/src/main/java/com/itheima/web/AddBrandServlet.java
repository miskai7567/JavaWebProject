package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.bean.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/12 17:07
 */
@WebServlet("/AddBrandServlet")
public class AddBrandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddBrandServlet...");
        // 1.接收浏览器传递过来的json数据
        //   request.getParameter()方式获取不到json格式的参数
      /*  String brandName = request.getParameter("brandName");
        System.out.println("brandName = " + brandName);*/

        // 方式一: 获取json参数,并转换为java对象
       /* // 获取json参数
        BufferedReader reader = request.getReader();
        String jsonS = reader.readLine();
        System.out.println("jsonS = " + jsonS);// {"brandName":"aaa","companyName":"aaa","ordered":"1","description":"aaa","status":1}

        // 把json字符串转换java对象
        Brand brand = JSON.parseObject(jsonS, Brand.class);
        System.out.println("brand = " + brand);*/


        // 方式二:  获取json参数,并转换为java对象
        Brand brand = JSON.parseObject(request.getInputStream(), Brand.class);
        System.out.println("brand = " + brand);


        // 2.调用service层,添加记录
        BrandService brandService = new BrandService();
        int rows = brandService.addBrand(brand);

        // 3.响应一个标识给前端--让前端根据标识进行页面调整
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
