package com.youqian.youji.service;

import com.youqian.youji.entity.Users;

public interface LoginService {

    Users findUserById(int userId);

    Users findUserByName(String username);

    Users userLogin(Users users);

    boolean userReg(Users users);
}
















