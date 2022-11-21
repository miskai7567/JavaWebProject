package com.itheima.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {

    @Update("Update set money=money-#{money} where name=#{from}")
    void kouqian(@Param("from") String from , @Param("money") int money);
    @Update("Update set money=money+#{money} where name=#{to}")
    void jiaqian(@Param("to") String to , @Param("money") int money);

}
