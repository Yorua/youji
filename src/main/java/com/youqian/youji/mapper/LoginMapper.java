package com.youqian.youji.mapper;

import com.youqian.youji.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    @Select("select * from users where userName=#{userName} and password=#{password}")
    Users userLogin(Users users);

    @Insert("insert into users values(null,#{userName},#{password},#{realName},#{sex},null,null,null)")
    boolean userReg(Users users);
}
