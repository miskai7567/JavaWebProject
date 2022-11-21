package com.itheima.service;

import com.itheima.bean.Brand;
import com.itheima.dao.BrandDao;
import com.itheima.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/14 12:05
 */
public class BrandService {
    /*调用dao层,查询所有*/
    public List<Brand> findAll() {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        List<Brand> list = brandDao.findAll();

        // 释放资源
        SqlSessionUtils.close(sqlSession);

        return list;
    }

    /*调用dao层,添加记录*/
    public int addBrand(Brand brand) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        int rows = brandDao.addBrand(brand);

        // 提交事务,释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }

    /*调用dao层,删除记录*/
    public int deleteBrand(int id) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        int rows = brandDao.deleteBrand(id);

        // 提交事务,释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }

    /*调用dao层,根据id查询记录*/
    public Brand findBrandById(int id) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        Brand brand = brandDao.findBrandById(id);

        // 提交事务,释放资源
        SqlSessionUtils.close(sqlSession);

        return brand;
    }

    /*调用dao层,修改记录*/
    public int updateBrand(Brand brand) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        int rows = brandDao.updateBrand(brand);

        // 提交事务,释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }
}
