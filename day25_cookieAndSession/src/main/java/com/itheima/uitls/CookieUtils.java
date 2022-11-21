package com.itheima.uitls;

import javax.servlet.http.Cookie;

/**
 * @Author pzl
 * @Date 2022/11/10 10:29
 */
public class CookieUtils {

    /**
     * 查找指定名称的cookie
     * @param cookieName  要查找的cookie名称
     * @param cookies 浏览器携带过来的所有cookie
     * @return 返回查找的cookie
     */
    public static Cookie getCookie(String cookieName,Cookie[] cookies){
        // 判断,遍历
        if (cookies != null){
            for (Cookie cookie : cookies) {
                // 判断cookie的键名
                String name = cookie.getName();
                if (cookieName.equals(name)){
                   return cookie;
                }
            }
        }

        // 说明没有找到cookie  或者 没有携带过来cookie
        return null;
    }
}
