package com.itheima.demo9_文件下载;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author pzl
 * @Date 2022/11/8 15:31
 */
@WebServlet("/ServletDownload")
public class ServletDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数---要下载的文件名
        String fileName = request.getParameter("fileName");
        System.out.println("fileName = " + fileName);

        // 2.获取一个关联了要下载的文件的输入流
        InputStream is = getServletContext().getResourceAsStream("download/" + fileName);

        // 3.设置2个头:
        // 3.1 获取要下载的文件的MIME类型
        String mimeType = getServletContext().getMimeType(fileName);

        // 3.2 设置Content-Type响应头,告诉浏览器文件的MIME类型
        response.setHeader("Content-Type", mimeType);

        // 对文件名进行编码----使用的是浏览器的编码规则进行编码
        // 先获取浏览器的版本信息
        String agent = request.getHeader("User-Agent");

        // 判断浏览器的版本---进行编码
        if (agent.contains("Firefox")){
            // 使用火狐浏览器的编码规则进行编码
            fileName = base64EncodeFileName(fileName);
        }else{
            // 使用其他浏览器的编码规则进行编码
            fileName = URLEncoder.encode(fileName,"UTF-8");
        }


        // 3.3 设置Content-Disposition响应头,告诉浏览器去下载文件
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);// 浏览器使用的编码格式编码后的数据

        // 4. 通过响应对象获取输出流
        ServletOutputStream os = response.getOutputStream();

        // 5. 定义一个字节数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        // 6. 定义一个int变量,用来存储读取到的字节个数
        int len;

        // 7. 循环读字节数据
        while ((len = is.read(bys)) != -1) {
            // 8. 循环写字节数据
            os.write(bys, 0, len);
        }
        // 9. 关闭流,释放资源
        os.close();
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // 火狐浏览器的编码
    public static String base64EncodeFileName(String fileName) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            return "=?UTF-8?B?"
                    + new String(base64Encoder.encode(fileName
                    .getBytes("UTF-8"))) + "?=";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
