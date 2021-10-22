package com.bird.bird.Service;

import com.bird.bird.Dao.Bird_informationDao;
import com.bird.bird.entity.BirdInfo;
import com.bird.bird.entity.Bird_information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
public class BirdInformationService {
    @Autowired
    Bird_informationDao birdInformationDao;
    public Page<Bird_information> getAllBirds(Pageable pageable){
        return birdInformationDao.findAll(pageable);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean save(Bird_information bird_information){
        Bird_information result = birdInformationDao.save(bird_information);

        if(result != null){
            return true;
        }else{
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Bird_information> searchByName(String name){
        return birdInformationDao.searchByName(name);
    }
}
