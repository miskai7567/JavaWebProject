package com.itheima.web;

import com.itheima.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/10 17:06
 */
@WebServlet("/ServletCheckCode")
public class ServletCheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 获取session对象
        HttpSession session = request.getSession();

        // 使用工具类生成一个验证码,响应到页面上
        // 参数1: 验证码图片的宽度  参数2: 验证码图片的高度  参数3: 通过响应对象获取的输出就  参数4:  验证码字符的数量
        String code = CheckCodeUtil.outputVerifyImage(150, 40, response.getOutputStream(), 4);
        System.out.println("生成的验证码code = " + code);

        // 把验证码存储到session域对象中
       session.setAttribute("checkCode",code);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
