package com.youqian.youji;

import com.youqian.youji.entity.Users;
import com.youqian.youji.mapper.LoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YoujiApplicationTests {

    @Autowired
    private LoginMapper loginMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void selectUser() {
        Users users=new Users();
        users.setUsername("1");
        users.setPassword("1");
        Users user = loginMapper.userLogin(users);
        System.out.println(user);
    }
}
