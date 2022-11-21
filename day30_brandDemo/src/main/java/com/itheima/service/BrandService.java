package com.itheima.service;

import com.itheima.bean.Brand;
import com.itheima.bean.PageBean;
import com.itheima.dao.BrandDao;
import com.itheima.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/15 12:10
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

    /*调用dao层,批量删除*/
    public int batchDeleteBrand(int[] ids) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        int rows = brandDao.batchDeleteBrand(ids);

        // 提交事务,释放资源
        SqlSessionUtils.commitAndClose(sqlSession);
        return rows;
    }

    /*调用dao层,分页查询*/
    public PageBean<Brand> findPage(int currentPage, int pageSize) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        // 查询总记录数
        int totalCount = brandDao.findTotalCount();

        // 查询当前页的数据
        int begin = (currentPage - 1) * pageSize;
        List<Brand> list = brandDao.findPage(begin,pageSize);

        // 封装总记录数和当前页的数据
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setList(list);

        // 释放资源
        SqlSessionUtils.close(sqlSession);

        return pageBean;
    }

    /*调用dao层,根据条件分页查询*/
    public PageBean<Brand> findPageByCondition(int currentPage, int pageSize, Brand brand) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao接口的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用方法,执行sql语句
        // 根据条件查询总记录数
        int totalCount = brandDao.findTotalCountByCondition(brand);

        // 根据条件查询当前页的数据
        int begin = (currentPage - 1) * pageSize;
        List<Brand> list = brandDao.findPageByCondition(begin,pageSize,brand);

        // 封装总记录数和当前页的数据
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setList(list);

        // 释放资源
        SqlSessionUtils.close(sqlSession);

        return pageBean;
    }

    // 调用dao层,进行修改
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
}
