package com.example.work.web;

import com.alibaba.fastjson.JSON;
import com.example.work.bean.Book;
import com.example.work.service.BookService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/15 15:29
 */
@WebServlet("/book/*")
public class BookServlet extends BaseServlet {

    // 查询所有
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 把之前查询所有的Servlet里面执行的代码放在这
        // 1.调用service层,查询所有,得到list集合
        BookService bookService = new BookService();
        List<Book> list = bookService.findAll();

        // 2.把list集合转换为json
        String listJson = JSON.toJSONString(list);

        //System.out.println("listJson = " + listJson);

        // 3.响应json数据到页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(listJson);
    }

    // 添加记录
    public void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.接收请求参数---添加的记录数据
        Book book = JSON.parseObject(request.getInputStream(), Book.class);
        System.out.println(book);

        // 2.调用service层,进行添加数据
        BookService brandService = new BookService();
        int rows = brandService.addBook(book);

        System.out.println("rows"+rows);
        // 3.响应标识给页面
        if (rows > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    // 删除记录
    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        System.out.println(id);

        // 2.调用service层,进行添加数据
        BookService brandService = new BookService();
        int i = brandService.deleteBook(id);


        // 3.响应标识给页面
        if (i > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    // 修改记录
    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Book o = JSON.parseObject(request.getInputStream(), Book.class);


        // 2.调用service层,进行添加数据
        BookService brandService = new BookService();
        int i = brandService.updateBook(o);


        // 3.响应标识给页面
        if (i > 0){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }




}
