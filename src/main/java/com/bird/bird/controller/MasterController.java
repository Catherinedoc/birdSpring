package com.bird.bird.controller;

import com.bird.bird.Dao.MasterDao;
import com.bird.bird.entity.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/master")
public class MasterController {
    @Autowired
    private MasterDao masterDao;

    @ResponseBody
    @GetMapping("/findAll")
    public List<Master> getAll(){
        return masterDao.findAll();
    }
}
