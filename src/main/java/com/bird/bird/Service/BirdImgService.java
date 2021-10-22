package com.bird.bird.Service;

import com.bird.bird.Dao.Bird_imgDao;
import com.bird.bird.entity.Bird_img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class BirdImgService {
    @Autowired
    Bird_imgDao birdImgDao;

    @Transactional(rollbackFor = Exception.class)
    public void save(Bird_img bird_img) {
        birdImgDao.save(bird_img);
    }
}
