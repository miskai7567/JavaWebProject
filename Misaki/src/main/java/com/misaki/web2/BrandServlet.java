package com.misaki.web2;

import com.alibaba.fastjson.JSON;
import com.misaki.bean.Brand;
import com.misaki.bean.PageBean;
import com.misaki.service.BrandService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        Brand o = JSON.parseObject(request.getInputStream(), Brand.class);


        // 2.调用service层,进行添加数据
        BrandService brandService = new BrandService();
        int i = brandService.updateBrand(o);


        // 3.响应标识给页面
        if (i > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    // 删除记录
    public void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));


        // 2.调用service层,进行添加数据
        BrandService brandService = new BrandService();
        int i = brandService.deleteBrand(id);


        // 3.响应标识给页面
        if (i > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    public void findPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //Brand brand = JSON.parseObject(request.getInputStream(), Brand.class);
        //System.out.println("brand = " + brand);
        System.out.println(currentPage);
        System.out.println(pageSize);

        // 2.调用service层,进行添加数据
        BrandService brandService = new BrandService();
        PageBean<Brand> pageBean= brandService.findPage(currentPage,pageSize);

        String s = JSON.toJSONString(pageBean);
        // 3.响应标识给页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void findPageByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("findPageByCondition...");
        // 1.获取请求参数---当前页码,每页显示的条数,条件对象
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        Brand brand = JSON.parseObject(request.getInputStream(), Brand.class);

        // 2.调用service层,进行查询,得到PageBean对象
        BrandService brandService = new BrandService();
        PageBean<Brand> pageBean = brandService.findPageByCondition(currentPage, pageSize, brand);

        // 3.把PageBean转换为json
        String json = JSON.toJSONString(pageBean);

        // 4.响应json数据给前端页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
    public void batchDeleteBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.接收请求参数---添加的记录数据
        int[] ids =JSON.parseObject(request.getInputStream(),int[].class);
        // 2.调用service层,进行添加数据
        BrandService brandService = new BrandService();
        int rows = brandService.batchDeleteBrand(ids);

        // 3.响应标识给页面
        if (rows > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }


}
