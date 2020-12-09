package com.travelElf.youji.service.Impl;

import com.travelElf.youji.common.result.ResultEntity;
import com.travelElf.youji.constant.MessageConstant;
import com.travelElf.youji.dto.UserLoginResultDto;
import com.travelElf.youji.entity.User;
import com.travelElf.youji.mapper.UserMapper;
import com.travelElf.youji.req.UserLoginReq;
import com.travelElf.youji.req.UserRegisterReq;
import com.travelElf.youji.req.UserUpdatePswReq;
import com.travelElf.youji.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    UserMapper userMapper;

    @Override
    public ResultEntity login(UserLoginReq req) {
        Subject subject = SecurityUtils.getSubject();
        req.setPassWord(DigestUtils.md5DigestAsHex(req.getPassWord().getBytes()));
        UsernamePasswordToken token = new UsernamePasswordToken(req.getUserName(), req.getPassWord());
        try {
            subject.login(token);
            return ResultEntity.createSuccessResult(new UserLoginResultDto(req.getUserName()));
        } catch (UnknownAccountException e) {
            return ResultEntity.createFailResult(MessageConstant.USER_NAME_NOT_EXIST);
        }catch (IncorrectCredentialsException e) {
            return ResultEntity.createFailResult(MessageConstant.USER_PWD_FAIL);
        }catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.createFailResult(MessageConstant.LOGIN_FAIL);
        }
    }

    @Override
    public ResultEntity register(UserRegisterReq req) {
        try {
            req.setPassWord(DigestUtils.md5DigestAsHex(req.getPassWord().getBytes()));
            if (null != userMapper.isUserReName(req.getUserName())) {
                return ResultEntity.createFailResult(MessageConstant.USER_NAME_REPEAT);
            }else if(null != userMapper.isUserReEmail(req.getEmail())){
                return ResultEntity.createFailResult(MessageConstant.EMAIL_IS_REGIST);
            }
            userMapper.register(req);
            return ResultEntity.createSuccessResult(null);
        }catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.createFailResult(MessageConstant.REGIST_FAIL);
        }
    }


}
