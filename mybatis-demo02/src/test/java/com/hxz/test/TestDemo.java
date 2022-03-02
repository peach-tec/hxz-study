package com.hxz.test;

import com.hxz.mybatis.entity.Emp;
import com.hxz.mybatis.mapper.DeptMapper;
import com.hxz.mybatis.mapper.DynamicSQLMapper;
import com.hxz.mybatis.mapper.EmpMapper;
import com.hxz.mybatis.utils.MybatisUtils;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void testDemo07() {
        DynamicSQLMapper mapper = MybatisUtils.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp();
//        emp.setEmpName("test002");
        mapper.listEmp1(emp).forEach(System.out::println);
    }

    @Test
    public void testDemo08() {
        DynamicSQLMapper mapper = MybatisUtils.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp();
//        emp.setEmpName("test002");
        mapper.listEmp2(emp).forEach(System.out::println);
    }

    @Test
    public void testDemo09() {
        DynamicSQLMapper mapper = MybatisUtils.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp();
//        emp.setEmpName("test002");
        mapper.listEmp3(emp).forEach(System.out::println);
    }

    @Test
    public void testDemo10() {
        DynamicSQLMapper mapper = MybatisUtils.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp();
        emp.setEmpName("test002");
        emp.setAge(11);
        mapper.listEmp4(emp).forEach(System.out::println);
    }

    @Test
    public void testDemo11() {
        DynamicSQLMapper mapper = MybatisUtils.getMapper(DynamicSQLMapper.class);
        System.out.println(mapper.deleteBatch(new Integer[]{1, 2, 3}));
    }

    @Test
    public void testDemo12() {
        DynamicSQLMapper mapper = MybatisUtils.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Emp emp = new Emp();
            emp.setEmpName("test" + i);
            emp.setAge(10 + i);
            emp.setSex(i % 2 == 0 ? "男" : "女");
            emp.setEmail("14587@qq" + i);
            emp.setDid(i);
            emps.add(emp);
        }
        System.out.println(mapper.insertBatch(emps));
    }

    @Test
    public void testDemo13() {
        DynamicSQLMapper mapper = MybatisUtils.getMapper(DynamicSQLMapper.class);
        mapper.listEmp5().forEach(System.out::println);
    }
}
