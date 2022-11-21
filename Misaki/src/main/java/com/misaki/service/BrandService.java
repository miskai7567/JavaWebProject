package com.misaki.service;

import com.misaki.bean.Brand;
import com.misaki.bean.PageBean;
import com.misaki.dao.BrandDao;
import com.misaki.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BrandService {
    public List<Brand> findAll(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        BrandDao mapper = sqlSession.getMapper(BrandDao.class);

        List<Brand> Brands = mapper.findAll();

        SqlSessionUtils.close(sqlSession);

        return Brands;

    }

    public int addBrand(Brand brand){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        BrandDao mapper = sqlSession.getMapper(BrandDao.class);

        int add = mapper.add(brand);

        SqlSessionUtils.commitAndClose(sqlSession);

        return add;
    }

    public Brand findById(int id) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用dao的方法根据id查询
        Brand brand = brandDao.findById(id);

        // 释放资源
        SqlSessionUtils.close(sqlSession);

        return brand;
    }

    /*调用dao层,修改记录*/
    public int updateBrand(Brand brand) {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用dao的方法修改记录
        int rows = brandDao.updateBrand(brand);

        // 提交事务并释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }

    public int deleteBrand(int id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用dao的方法修改记录
        int rows = brandDao.deleteById(id);

        // 提交事务并释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }



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
        PageBean<Brand> pageBean = new PageBean<>(list,totalCount);
        //pageBean.setTotalCount(totalCount);
        //pageBean.setList(list);

        // 释放资源
        SqlSessionUtils.close(sqlSession);

        return pageBean;
    }

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

    public int batchDeleteBrand(int[] ids) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取dao的代理对象
        BrandDao brandDao = sqlSession.getMapper(BrandDao.class);

        // 调用dao的方法修改记录
        int rows = brandDao.batchDeleteBrand(ids);

        // 提交事务并释放资源
        SqlSessionUtils.commitAndClose(sqlSession);

        return rows;
    }
}
