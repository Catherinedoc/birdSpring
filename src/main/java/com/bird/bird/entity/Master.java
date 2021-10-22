package com.bird.bird.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Proxy(lazy = false)
@Entity
@Data
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String master_account;
    private String master_password;
    private String master_image;
    private String master_name;
}
