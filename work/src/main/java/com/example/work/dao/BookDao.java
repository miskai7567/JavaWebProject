package com.example.work.dao;



import com.example.work.bean.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/11 12:13
 */
public interface BookDao {


    @Select("select * from tbl_book")
    List<Book> findAll();

    @Insert("insert into tbl_book values (null,#{type},#{name},#{description})")
    int add(Book book);

    @Update("update tbl_book set type=#{type},name=#{name},description=#{description} where id=#{id}")
    int updateBook(Book book);

    @Delete("delete from tbl_book where id=#{id}")
    int deleteBook(int id);


}
