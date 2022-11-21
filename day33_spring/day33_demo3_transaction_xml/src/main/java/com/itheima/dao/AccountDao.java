package com.itheima.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {

    void kouqian(@Param("from") String from , @Param("money") int money);

    void jiaqian(@Param("to") String to , @Param("money") int money);

}
