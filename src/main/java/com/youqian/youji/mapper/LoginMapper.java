package com.youqian.youji.mapper;

import com.youqian.youji.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    @Select("select * from users where userId=#{userId}")
    Users findUserById(int userId);

    @Select("select * from users where username=#{username}")
    Users findUserByName(String username);

    @Select("select * from users where userName=#{userName} and password=#{password}")
    Users userLogin(Users users);

    @Insert("insert into users(userName,password) values(#{userName},#{password})")
    boolean userReg(Users users);


}
