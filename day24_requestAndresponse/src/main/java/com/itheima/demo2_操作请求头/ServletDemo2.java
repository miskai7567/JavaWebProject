package com.itheima.demo2_操作请求头;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author pzl
 * @Date 2022/11/8 9:55
 */
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求头: 浏览器告诉服务器自己的属性,配置的, 以key value存在, 可能一个key对应多个value
        //api:  String  getHeader(String name);
        //常见的请求头:
        //- User-Agent: 浏览器信息
        //- Referer:来自哪个网站(防盗链)

        // 1.获取浏览器的版本信息
        String agentValue = request.getHeader("User-Agent");
        System.out.println("agentValue = " + agentValue);

        //靓女.jpg---编码---响应给浏览器---解码---靓女.jpg
        //由于不同的浏览器编码和解码的规则不一样,所以服务器编码的时候需要判断浏览器的版本
        if (agentValue.contains("Firefox")){
            // 火狐浏览器---按照火狐浏览器的编码规则对数据进行编码
        }else{
            // 其他浏览器---按照其他浏览器的编码规则对数据进行编码
        }

        // 2.获取请求来自哪个网站---上一个页面的路径
        String refererValue = request.getHeader("Referer");
        System.out.println("refererValue = " + refererValue);

        //防盗链---防止别的应用盗用本应用的链接
        if (refererValue.contains("www.baidu.com")){
            // 放行
        }else{
            // 不放行
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
