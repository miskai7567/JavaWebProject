package com.misaki.web;

import com.alibaba.fastjson.JSON;
import com.misaki.bean.Brand;
import com.misaki.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/AddBrandServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset=utf-8");
        //Map<String, String[]> parameterMap = request.getParameterMap();
        //Brand brand = new Brand();
        //try {
        //    BeanUtils.populate(brand,parameterMap);
        //} catch (IllegalAccessException e) {
        //    e.printStackTrace();
        //} catch (InvocationTargetException e) {
        //    e.printStackTrace();
        //}
        //
        //BrandService brandService = new BrandService();
        //int add = brandService.add(brand);
        //
        //if(add>0){
        //    response.sendRedirect(request.getContextPath()+"/findAll");
        //
        //}
        //else {
        //    response.getWriter().write("<h1>数据添加失败</h1>");
        //}

        //方法一
        //Brand brand = JSON.parseObject(request.getReader().readLine(), Brand.class);
        // 方式二:  获取json参数,并转换为java对象
        //BufferedReader reader = request.getReader();
        Brand brand = JSON.parseObject(request.getInputStream(), Brand.class);
        System.out.println("brand = " + brand);
        BrandService brandService = new BrandService();
        int add = brandService.addBrand(brand);
        System.out.println(add);
        if (add > 0){
            response.getWriter().write("success");
        }

        //else{
        //    response.getWriter().write("failed");
        //}

    }
}
