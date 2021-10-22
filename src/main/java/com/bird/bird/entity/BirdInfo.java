package com.bird.bird.entity;

import java.util.ArrayList;

public class BirdInfo {
    private Integer id;
    private String bird_name;
    private String bird_summary;
    private String bird_bcharacter;
    private String bird_identify;
    private String bird_lifehabit;
    private String bird_reproduction;
    private String bird_birds;   //某禽
    private String bird_department;  //某科
    private ArrayList<String> voiceList;
    private ArrayList<String> imageList;

    public Integer getId() {
        return id;
    }

    public String getBird_name() {
        return bird_name;
    }

    public String getBird_summary() {
        return bird_summary;
    }

    public String getBird_bcharacter() {
        return bird_bcharacter;
    }

    public String getBird_identify() {
        return bird_identify;
    }

    public String getBird_lifehabit() {
        return bird_lifehabit;
    }

    public String getBird_reproduction() {
        return bird_reproduction;
    }

    public String getBird_birds() {
        return bird_birds;
    }

    public String getBird_department() {
        return bird_department;
    }

    public ArrayList<String> getVoiceList() {
        return voiceList;
    }

    public ArrayList<String> getImageList() {
        return imageList;
    }
}
