package com.bird.bird.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Proxy(lazy = false)
@Entity()
@Data
public class Bird_img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String img_path;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private Bird_information bird;
}
