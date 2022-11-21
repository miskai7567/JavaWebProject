package com.misaki.web;

import com.alibaba.fastjson.JSON;
import com.misaki.bean.Brand;
import com.misaki.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAll")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandService brandService = new BrandService();

        List<Brand> Brands = brandService.findAll();


        String s = JSON.toJSONString(Brands);
        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(s);
        //request.setAttribute("list",Brands);
        //
        //request.getRequestDispatcher("brand.jsp").forward(request,response);
    }
}
