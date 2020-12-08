package com.travelElf.youji.mapper;

import com.travelElf.youji.entity.User;
import com.travelElf.youji.req.UserRegisterReq;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where user_name=#{userName}")
    User findUserByName(String userName);

    @Select("select * from user where user_name=#{userName}")
    User isUserReName(String userName);

    @Select("select * from user where email=#{email}")
    User isUserReEmail(String email);

    @Insert("insert into user(user_name,password,email) values(#{userName},#{passWord},#{email})")
    void register(UserRegisterReq req);


}
