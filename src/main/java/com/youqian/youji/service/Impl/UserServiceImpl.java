package com.youqian.youji.service.Impl;

import com.youqian.youji.entity.User;
import com.youqian.youji.mapper.UserMapper;
import com.youqian.youji.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("loginService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User findUserById(int userId) { return userMapper.findUserById(userId); }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public boolean register(User user) {
        return userMapper.userReg(user);
    }
}
