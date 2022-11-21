package com.itheima.dao;

import com.itheima.bean.Brand;

import java.util.List;

/**
 * @author pengzhilin
 * @version 1.0
 */
public interface BrandDao {
    /*查询所有*/
    List<Brand> findAll();

    /*添加记录*/
    int addBrand(Brand brand);
}
