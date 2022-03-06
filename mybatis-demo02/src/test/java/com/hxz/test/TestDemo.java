package com.hxz.test;

import com.hxz.mybatis.entity.Emp;
import com.hxz.mybatis.mapper.CacheMapper;
import com.hxz.mybatis.mapper.DeptMapper;
import com.hxz.mybatis.mapper.DynamicSQLMapper;
import com.hxz.mybatis.mapper.EmpMapper;
import com.hxz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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

    @Test
    public void testDemo14() {
        CacheMapper mapper1 = MybatisUtils.getMapper(CacheMapper.class);
        // 都从mapper1中查询相同数据时，sql只会执行一次
        System.out.println(mapper1.getById(4).toString());
        System.out.println(mapper1.getById(4).toString());

        CacheMapper mapper2 = MybatisUtils.getMapper(CacheMapper.class);
        // 从新的sqlsession中查询会重新执行查询sql
        System.out.println(mapper2.getById(4).toString());
    }

    @Test
    public void testDemo15() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        System.out.println(mapper1.getById(4).toString());
        sqlSession1.close(); // 关闭连接后数据才会被写入二级缓存
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(mapper2.getById(4).toString());
        sqlSession2.close();
    }
}
