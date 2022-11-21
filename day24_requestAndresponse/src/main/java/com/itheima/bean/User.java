package com.itheima.bean;

import java.util.Arrays;

/**
 * @Author pzl
 * @Date 2022/11/8 11:15
 */
public class User {
    private String username;
    private String password;
    private String[] hobby;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobby='" + Arrays.toString(hobby) + '\'' +
                '}';
    }
}
