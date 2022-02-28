package com.hxz.test;

import com.hxz.mybatis.mapper.EmpMapper;
import com.hxz.mybatis.utils.MybatisUtils;
import org.junit.Test;

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
}
