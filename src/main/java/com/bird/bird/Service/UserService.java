package com.bird.bird.Service;

import com.bird.bird.Dao.Unit_userDao;
import com.bird.bird.entity.Bird_information;
import com.bird.bird.entity.Unit_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {
    @Autowired
    Unit_userDao unitUserDao;
    public Page<Unit_user> getAllUsers(Pageable pageable){
        return unitUserDao.findAll(pageable);
    }

    @Transactional(rollbackFor = Exception.class)
    public String save(Unit_user unitUser){
        Unit_user result = unitUserDao.save(unitUser);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public List<Unit_user> searchByName(String name){
        return unitUserDao.searchByName(name);
    }
}
