package com.itheima.dao;

import com.itheima.bean.Brand;

import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/11 12:13
 */
public interface BrandDao {

    /*查询所有记录*/
    List<Brand> findAll();

    /*添加记录*/
    int addBrand(Brand brand);

    /*根据id查询记录*/
    Brand findById(int id);

    /*修改记录*/
    int updateBrand(Brand brand);
}
