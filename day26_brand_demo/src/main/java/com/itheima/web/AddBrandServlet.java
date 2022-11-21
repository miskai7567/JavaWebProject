package com.itheima.web;

import com.itheima.bean.Brand;
import com.itheima.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author pzl
 * @Date 2022/11/11 15:06
 */
@WebServlet("/AddBrandServlet")
public class AddBrandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理请求和响应乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取表单数据
        Map<String, String[]> map = request.getParameterMap();

        // 封装表单数据---Brand对象
        Brand brand = new Brand();
        try {
            BeanUtils.populate(brand,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用service层,进行添加记录
        BrandService brandService = new BrandService();
        int rows = brandService.addBrand(brand);

        // 重定向到FindAllServlet
        if (rows > 0){
            // 添加成功
            response.sendRedirect(request.getContextPath()+"/findAll");
        }else{
            // 添加失败
            response.getWriter().write("<h1>数据添加失败</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
