package com.hxz.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxz.mybatis.entity.Emp;
import com.hxz.mybatis.mapper.EmpMapper;
import com.hxz.mybatis.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-03-06-21:20
 * @address 成都
 */
public class TestDemo {
    @Test
    public void test01() {
        EmpMapper mapper = MybatisUtils.getMapper(EmpMapper.class);
        // 设置分页参数
        PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        // 获取分页相关信息
        PageInfo<Emp> page = new PageInfo<>(emps,5);
        System.out.println(page);
    }

    @Test
    public void test02() {
        EmpMapper mapper = MybatisUtils.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectByPageNumSize(1,5);
        // 获取分页相关信息
        System.out.println(emps);
    }
}
