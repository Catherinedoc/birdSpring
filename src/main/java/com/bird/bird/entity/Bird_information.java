package com.bird.bird.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Proxy(lazy = false)
@Entity()
@Data
public class Bird_information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String bird_name;
    private String bird_summary;
    private String bird_bcharacter;
    private String bird_identify;
    private String bird_lifehabit;
    private String bird_reproduction;
    private String bird_birds;   //某禽
    private String bird_department;  //某科

    @OneToMany(mappedBy = "bird",cascade = CascadeType.REMOVE,targetEntity = Bird_img.class,fetch = FetchType.EAGER)
    private Set<Bird_img> birdImg = new HashSet<Bird_img>();

    @OneToMany(mappedBy = "bird",cascade = CascadeType.REMOVE,targetEntity = Bird_voice.class,fetch = FetchType.EAGER)
    private Set<Bird_voice> birdVoice = new HashSet<Bird_voice>();
}
