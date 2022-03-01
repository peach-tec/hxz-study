package com.hxz.mybatis.mapper;

import com.hxz.mybatis.entity.Emp;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-02-28-21:08
 * @address 成都
 */
public interface EmpMapper {
    /**
     * 查询所有
     */
    List<Emp> listAll();

    List<Emp> listAll2();

    List<Emp> listAll3();
}
