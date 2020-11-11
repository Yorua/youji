package com.youqian.youji.service;

import com.youqian.youji.entity.User;

public interface UserService {

    User findUserById(int userId);

    User findUserByName(String username);

    boolean register(User user);
}
















