package com.example.work.service;


import com.example.work.bean.Book;
import com.example.work.dao.BookDao;
import com.example.work.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookService {


    public List<Book> findAll(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        BookDao mapper = sqlSession.getMapper(BookDao.class);

        List<Book> Book= mapper.findAll();

        SqlSessionUtils.close(sqlSession);

        System.out.println(Book);
        return Book;

    }

    public int addBook(Book book) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        BookDao mapper = sqlSession.getMapper(BookDao.class);

        int add=mapper.add(book);

        SqlSessionUtils.commitAndClose(sqlSession);

        return add;
    }

    public int deleteBook(int id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao的代理对象
        BookDao brandDao = sqlSession.getMapper(BookDao.class);

        // 调用dao的方法修改记录
        int rows = brandDao.deleteBook(id);

        // 提交事务并释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }

    public int updateBook(Book o) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao的代理对象
        BookDao brandDao = sqlSession.getMapper(BookDao.class);

        // 调用dao的方法修改记录
        int rows = brandDao.updateBook(o);

        // 提交事务并释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }
}
