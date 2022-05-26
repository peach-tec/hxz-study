package com.hxz.id.user.service;


import com.hxz.id.user.entity.User;

import java.util.List;

public interface UserService {

    boolean save(User record);

    boolean saveBatch(List<User> records);
}
