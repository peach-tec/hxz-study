package com.hxz.mybatis.mapper;

import com.hxz.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-02-24-20:27
 * @address 成都
 */
public interface UserMapper {
    /**
     * 插入
     */
    int insertUser(User user);

    /**
     * 根据ID查询
     */
    User getById(Integer id);

    /**
     * 查询所有
     */
    List<User> listUsers();

    /**
     * 根据用户名查询
     */
    User getByUsername(String username);

    /**
     * 通过用户名和密码查询
     */
    User getByUsernameAndPassword(String username, String password);

    /**
     * 查询用户
     */
    User getByParams(Map<String, Object> params);

    /**
     * 查询用户
     */
    User getUser(@Param("username") String username, @Param("password") String password);

    /**
     * 查询所有的数据并转成map
     */
    @MapKey("id")
    // 标识map的键，取数据库中的唯一值的字段
    Map<String, Object> mapUser();

    /**
     * 模糊查询
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteBatch(@Param("ids")String ids);

    /**
     * 通过username批量删除
     */
    int deleteBatchByUsername(@Param("username") String usernames);
}
