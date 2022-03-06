package com.hxz.mybatis.mapper;

import com.hxz.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 缓存测试
 * @copyright &copy; DYH
 * @date 2022-03-05-20:24
 * @address 成都
 */
public interface CacheMapper {
    Emp getById(@Param("id") Integer id);
}
