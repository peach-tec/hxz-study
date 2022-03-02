package com.hxz.mybatis.mapper;

import com.hxz.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 动态sql演示
 * @copyright &copy; DYH
 * @date 2022-03-01-21:32
 * @address 成都
 */
public interface DynamicSQLMapper {
    /**
     * 多条件查询之if标签
     */
    List<Emp> listEmp1(Emp emp);

    /**
     * 多条件查询值where标签
     */
    List<Emp> listEmp2(Emp emp);

    /**
     * 多条件查询值trim标签
     */
    List<Emp> listEmp3(Emp emp);

    /**
     * 多条件查询值choose、when、otherwise标签
     */
    List<Emp> listEmp4(Emp emp);

    /**
     * 批量操作之foreach标签
     */
    int deleteBatch(@Param("ids") Integer[] ids);

    /**
     * 批量操作之foreach标签
     */
    int insertBatch(@Param("emps") List<Emp> emps);

    /**
     * 查询操作之sql标签
     */
    List<Emp> listEmp5();
}
