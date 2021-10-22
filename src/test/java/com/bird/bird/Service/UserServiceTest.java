package com.bird.bird.Service;

import com.bird.bird.entity.Unit_user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    void save(){
        Unit_user unit_user = new Unit_user();
        unit_user.setUser_name("张三");
        unit_user.setUser_account("1234567");
        unit_user.setUser_password("123456");
        userService.save(unit_user);

    }

}