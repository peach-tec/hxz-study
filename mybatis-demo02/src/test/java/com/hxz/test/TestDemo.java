package com.hxz.test;

import com.hxz.mybatis.entity.Emp;
import com.hxz.mybatis.mapper.DeptMapper;
import com.hxz.mybatis.mapper.EmpMapper;
import com.hxz.mybatis.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-02-28-21:09
 * @address 成都
 */
public class TestDemo {
    @Test
    public void testDemo01() {
        EmpMapper emps = MybatisUtils.getMapper(EmpMapper.class);
        emps.listAll().forEach(System.out::println);
    }

    @Test
    public void testDemo02() {
        EmpMapper emps = MybatisUtils.getMapper(EmpMapper.class);
        emps.listAll2().forEach(System.out::println);
    }

    @Test
    public void testDemo03() {
        EmpMapper emps = MybatisUtils.getMapper(EmpMapper.class);
        emps.listAll3().forEach(System.out::println);
    }

    @Test
    public void testDemo04() {
        EmpMapper emps = MybatisUtils.getMapper(EmpMapper.class);
        List<Emp> emps1 = emps.listAll3();
        Emp emp = emps1.get(0);
        System.out.println(emp.getEmpName());
        System.out.println("*************************分割线*************************");
        System.out.println(emp.getDept());
    }

    @Test
    public void testDemo05() {
        DeptMapper deptMapper = MybatisUtils.getMapper(DeptMapper.class);
        deptMapper.listAll().forEach(System.out::println);
    }

    @Test
    public void testDemo06() {
        DeptMapper deptMapper = MybatisUtils.getMapper(DeptMapper.class);
        deptMapper.listByStep().forEach(System.out::println);
    }
}
