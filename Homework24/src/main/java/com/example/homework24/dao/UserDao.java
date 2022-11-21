package com.example.homework24.dao;

import com.example.homework24.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Insert("Insert into user(username,password) value (#{username},#{password})")
    //void add(String username,String password);
    void add(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
