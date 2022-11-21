package com.itheima.web2;

import com.alibaba.fastjson.JSON;
import com.itheima.bean.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/15 15:29
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {

    // 查询所有
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 把之前查询所有的Servlet里面执行的代码放在这
        // 1.调用service层,查询所有,得到list集合
        BrandService brandService = new BrandService();
        List<Brand> list = brandService.findAll();

        // 2.把list集合转换为json
        String listJson = JSON.toJSONString(list);

        System.out.println("listJson = " + listJson);

        // 3.响应json数据到页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(listJson);
    }

    // 添加记录
    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.接收请求参数---添加的记录数据
        Brand brand = JSON.parseObject(request.getInputStream(), Brand.class);
        System.out.println("brand = " + brand);

        // 2.调用service层,进行添加数据
        BrandService brandService = new BrandService();
        int rows = brandService.addBrand(brand);

        // 3.响应标识给页面
        if (rows > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    // 修改记录
    public void updateBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    // 删除记录
    public void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}
