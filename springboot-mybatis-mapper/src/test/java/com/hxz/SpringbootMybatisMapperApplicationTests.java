package com.hxz;


import com.hxz.entity.User;
import com.hxz.mapper.RoleMapper;
import com.hxz.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpringbootMybatisMapperApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void userList() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}
