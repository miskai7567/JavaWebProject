package com.itheima.dao;

import com.itheima.bean.Brand;
import org.apache.ibatis.annotations.Param;

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

    /*批量删除*/
    int batchDeleteBrand(@Param("ids") int[] ids);

    /*查询总记录数*/
    int findTotalCount();

    /*分页查询*/
    List<Brand> findPage(@Param("begin") int begin, @Param("pageSize") int pageSize);

    /*根据条件查询总记录数*/
    int findTotalCountByCondition(Brand brand);

    /*根据分页查询*/
    List<Brand> findPageByCondition(@Param("begin") int begin, @Param("pageSize") int pageSize, @Param("brand") Brand brand);

    /*修改记录*/
    int updateBrand(Brand brand);

    /*删除记录*/
    int deleteBrand(int id);
}
