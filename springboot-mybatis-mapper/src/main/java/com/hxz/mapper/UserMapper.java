package com.hxz.mapper;

import com.hxz.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

// 下面两个注解可不选，也可选其一
//@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {
}
