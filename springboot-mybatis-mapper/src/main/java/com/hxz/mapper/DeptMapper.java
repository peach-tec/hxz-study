package com.hxz.mapper;

import com.hxz.entity.Dept;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface DeptMapper extends Mapper<Dept> {
    void insertDept(Dept dept);
}
