package com.youqian.youji.service.Impl;

import com.youqian.youji.entity.Users;
import com.youqian.youji.mapper.LoginMapper;
import com.youqian.youji.service.LoginService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Override
    public Users userLogin(Users users) {
        return loginMapper.userLogin(users);
    }

    @Override
    public boolean userReg(Users users) {
        return loginMapper.userReg(users);
    }
}
