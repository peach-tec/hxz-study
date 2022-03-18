package com.hxz.mapper;

import com.hxz.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface DeptMapper extends Mapper<Dept> {
    void insertDept(Dept dept);

    List<Dept> selectAllByPage(RowBounds rowBounds);

    List<Dept> selectAllByPage();

    List<Dept> selectByPageNumSize(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<Dept> selectAllByParamsWithPageNumSize(Map<String, Object> params);
}
