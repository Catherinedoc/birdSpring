package com.bird.bird.Dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class MasterDaoTest {
    @Autowired
    public MasterDao masterDao;
    @Test
    void findAll(){
        System.out.println(masterDao.findAll());
    }
}