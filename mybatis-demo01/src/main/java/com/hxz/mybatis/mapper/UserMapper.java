package com.hxz.mybatis.mapper;

import com.hxz.mybatis.entity.User;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-02-24-20:27
 * @address 成都
 */
public interface UserMapper {
    int insertUser(User user);

    User getById(Integer id);

    List<User> listUsers();
}
