package com.bird.bird.Dao;

import com.bird.bird.entity.Bird_information;
import com.bird.bird.entity.Unit_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Unit_userDao extends JpaRepository<Unit_user,String> {
    @Query(value = "select * from unit_user where user_name = ?",nativeQuery = true)
    List<Unit_user> searchByName(String name);
}
