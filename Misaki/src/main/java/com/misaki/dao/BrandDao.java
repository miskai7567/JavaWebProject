package com.misaki.dao;


import com.misaki.bean.Brand;
import com.misaki.bean.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author pzl
 * @Date 2022/11/11 12:13
 */
public interface BrandDao {
    List<Brand> findAll();

    int add(Brand brand);

    Brand findById(int id);

    int updateBrand(Brand brand);

    int deleteById(int id);

    List<Brand> findPage(@Param("begin") int begin, @Param("pageSize") int pageSize);

    int findTotalCount();

    int findTotalCountByCondition(Brand brand);

    /*根据分页查询*/
    List<Brand> findPageByCondition(@Param("begin") int begin, @Param("pageSize") int pageSize, @Param("brand") Brand brand);

    int batchDeleteBrand(@Param("ids") int[] ids);


    ///*查询所有记录*/
    //List<Brand> findAll();
    //
    ///*添加记录*/
    //int addBrand(Brand brand);
    //
    ///*根据id查询记录*/
    //Brand findById(int id);
    //
    ///*修改记录*/
    //int updateBrand(Brand brand);
}
