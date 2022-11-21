package com.itheima.dao;

import com.itheima.bean.Brand;

import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/12 16:38
 */
public interface BrandDao {
    /*查询所有记录*/
    List<Brand> findAll();

    /*添加记录*/
    int addBrand(Brand brand);
}
