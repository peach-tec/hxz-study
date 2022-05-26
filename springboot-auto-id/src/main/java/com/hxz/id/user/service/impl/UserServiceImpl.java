package com.hxz.id.user.service.impl;

import com.hxz.id.user.dao.UserMapper;
import com.hxz.id.user.entity.User;
import com.hxz.id.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean save(User record) {
        int count = userMapper.insert(record);
        return count > 0;
    }

    @Override
    public boolean saveBatch(List<User> records) {
        return userMapper.insertBatch(records) > 0;
    }
}
