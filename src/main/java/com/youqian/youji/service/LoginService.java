package com.youqian.youji.service;

import com.youqian.youji.entity.Users;

public interface LoginService {
    public Users userLogin(Users users);

    public boolean userReg(Users users);
}
