package com.hxz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import com.hxz.entity.Dept;
import com.hxz.mapper.DeptMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-03-18-20:57
 * @address 成都
 */
@SpringBootTest
public class PageHelperTestDemo {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * RowBounds方式的调用
     */
    @Test
    public void test001() {
        List<Dept> list = deptMapper.selectAllByPage(new RowBounds(1, 10));
        list.forEach(System.out::println);

        System.out.println("=======================================================================");

        PageRowBounds pageRowBounds = new PageRowBounds(1, 10);
        List<Dept> depts = deptMapper.selectAllByPage(pageRowBounds);
        System.out.println("总共有" + pageRowBounds.getTotal() + "条数据");
        depts.forEach(System.out::println);
    }

    /**
     * PageHelper.startPage 静态方法调用
     */
    @Test
    public void test002() {
        PageHelper.startPage(1, 10);
        // 第一个mybatis方法会被分页
        List<Dept> depts = deptMapper.selectAllByPage();
        depts.forEach(System.out::println);
        System.out.println("=======================================================================");
        depts = new ArrayList<>();
        // 再次调用不会分页
        depts = deptMapper.selectAllByPage();
        depts.forEach(System.out::println);
        System.out.println("=======================================================================");
        depts = new ArrayList<>();
        // 重新设置分页参数后再次调用会被分页
        PageHelper.startPage(1, 10);
        depts = deptMapper.selectAllByPage();
        depts.forEach(System.out::println);
    }

    /**
     * 使用参数方式
     */
    @Test
    public void test003() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", 1);
        params.put("pageSize", 5);
        PageHelper.startPage(params);
        List<Dept> depts = deptMapper.selectAll();
        depts.forEach(System.out::println);
        System.out.println("=======================================================================");
        depts = new ArrayList<>();
        // 传递分页参数到方法
        depts = deptMapper.selectByPageNumSize(1, 5);
        depts.forEach(System.out::println);
        System.out.println("=======================================================================");
        depts = new ArrayList<>();
        // 在查询条件对象中传递分页参数
        depts = deptMapper.selectAllByParamsWithPageNumSize(params);
        depts.forEach(System.out::println);
    }

    /**
     * 使用PageInfo
     */
    @Test
    public void test004() {
        // 可以使用上面任何一种分页查询进行封装
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", 1);
        params.put("pageSize", 5);
        Page<Dept> depts = PageHelper.startPage(params).doSelectPage(() -> {
            deptMapper.selectAll();
        });
        System.out.println(depts);
        System.out.println("=======================================================================");
        PageHelper.startPage(params);
        List<Dept> depts1 = deptMapper.selectAll();
        PageInfo<Dept> info = new PageInfo<>(depts1);
        System.out.println(info);
    }
}
