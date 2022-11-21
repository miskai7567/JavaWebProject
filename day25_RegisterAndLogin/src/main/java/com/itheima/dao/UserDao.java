package com.itheima.dao;

import com.itheima.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author pzl
 * @Date 2022/11/8 16:12
 */
public interface UserDao {
    /*根据用户名查询*/
    @Select("select * from tb_user where username = #{username}")
    User findByUsername(String username);

    /*注册用户*/
    @Insert("insert into tb_user values(null,#{username},#{password})")
    void add(@Param("username") String username, @Param("password") String password);

    /*根据用户名和密码查询*/
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
