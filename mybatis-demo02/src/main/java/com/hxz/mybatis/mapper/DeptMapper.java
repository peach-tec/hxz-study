package com.hxz.mybatis.mapper;

import com.hxz.mybatis.entity.Dept;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-02-28-21:08
 * @address 成都
 */
public interface DeptMapper {
    /**
     * 获取所有
     */
    List<Dept> listAll();
    /**
     * 分步查询
     */
    List<Dept> listByStep();
}
