package com.youqian.youji.mapper;

import com.youqian.youji.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where user_id=#{userId}")
    User findUserById(int userId);

    @Select("select * from user where user_name=#{username}")
    User findUserByName(String username);

    @Insert("insert into user(user_name,password,email) values(#{username},#{password},#{email})")
    boolean userReg(User user);


}
