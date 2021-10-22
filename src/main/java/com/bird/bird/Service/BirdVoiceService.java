package com.bird.bird.Service;

import com.bird.bird.Dao.Bird_voiceDao;
import com.bird.bird.entity.Bird_voice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BirdVoiceService {
    @Autowired
    Bird_voiceDao bird_voiceDao;

    @Transactional(rollbackFor = Exception.class)
    public void save(Bird_voice bird_voice){
        bird_voiceDao.save(bird_voice);
    }
}
