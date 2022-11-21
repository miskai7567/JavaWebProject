package com.itheima.demo4_BeanUtils封装请求参数;

import com.itheima.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @Author pzl
 * @Date 2022/11/8 10:21
 */
@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理乱码
        request.setCharacterEncoding("utf-8");

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
        }

        // 自定义封装数据
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setHobby(hobbies);
        System.out.println("user = " + u);


        // 使用第三方框架BeanUtils封装数据
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
