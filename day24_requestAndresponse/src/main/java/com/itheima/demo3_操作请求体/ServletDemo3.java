package com.itheima.demo3_操作请求体;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @Author pzl
 * @Date 2022/11/8 10:21
 */
@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*  // 没有中文的参数演示
        // 获取指定的请求参数
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String password = request.getParameter("password");
        System.out.println("password = " + password);

        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("hobbies: " + Arrays.toString(hobbies));

        // 获取所有参数
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String[] valueArr = map.get(key);
            System.out.println(key + " = " + Arrays.toString(valueArr));
        }*/


        // tomcat7插件get请求参数乱码处理方式一:
        /*// 获取指定的请求参数
        String username = request.getParameter("username");
        System.out.println("处理乱码之前username = " + username);

        // 把乱码--使用ISO-8859-1转换为字节数字---使用utf-8编码转换为字符串
        byte[] bytes = username.getBytes("ISO-8859-1");
        username = new String(bytes, "utf-8");
        System.out.println("处理乱码之后username = " + username);*/


        // tomcat7插件get请求参数乱码处理方式二: 只需要在tomcat7的配置里面设置编码即可
        // 获取指定的请求参数
        //String username = request.getParameter("username");
        //System.out.println("username = " + username);


       /* // tomcat7插件post请求参数乱码处理: --> void setCharacterEncoding(String env); 设置请求体的编码
        // 设置请求体的编码
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        System.out.println("username = " + username);*/


        /*// tomcat8软件post请求参数乱码处理: --> void setCharacterEncoding(String env); 设置请求体的编码
        // 设置请求体的编码
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        System.out.println("username = " + username);*/


        // tomcat8软件get请求参数乱码处理: tomcat8软件内部已处理,不需要程序员手动处理
        String username = request.getParameter("username");
        System.out.println("username = " + username);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
