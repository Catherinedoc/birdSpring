package com.bird.bird.controller;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import java.util.List;

public class SearchInfo {
    public String searchName;
    public List<String> serchBelong;

}
