package com.misaki.web;

import com.alibaba.fastjson.JSON;
import com.misaki.bean.Brand;
import com.misaki.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/11 15:36
 */
@WebServlet("/findById")
public class FindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收id
        String bid = request.getParameter("id");
        int id = Integer.parseInt(bid);

        // 2.调用service层,传入id,根据id查询记录
        BrandService brandService = new BrandService();
        Brand brand = brandService.findById(id);

        String s = JSON.toJSONString(brand);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

        //// 3.把查询到的记录存储到session域对象中
        //request.getSession().setAttribute("brand",brand);
        //
        //// 4.重定向到updateBrand.jsp
        //response.sendRedirect(request.getContextPath() + "/updateBrand.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
