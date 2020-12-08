package com.travelElf.youji.service;

import com.travelElf.youji.common.result.ResultEntity;
import com.travelElf.youji.req.UserLoginReq;
import com.travelElf.youji.req.UserRegisterReq;

public interface IUserService {

    ResultEntity login(UserLoginReq req);

    ResultEntity register(UserRegisterReq req);

}
















