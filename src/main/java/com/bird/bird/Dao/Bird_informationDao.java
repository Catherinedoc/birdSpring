package com.bird.bird.Dao;

import com.bird.bird.entity.Bird_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bird_informationDao extends JpaRepository<Bird_information,Integer> {
    @Query(value = "select * from bird_information where bird_name = ?",nativeQuery = true)
    List<Bird_information> searchByName(String name);

}
