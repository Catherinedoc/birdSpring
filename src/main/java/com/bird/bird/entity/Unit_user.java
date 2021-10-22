package com.bird.bird.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Proxy(lazy = false)
@Entity
@Data
public class Unit_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户账号
     */
    private String user_account;
    /**
     * 用户密码
     */
    private String user_password;
    /**
     * 单位名称
     */
    private String user_name;
    /**
     * 创建日期
     */
    private String user_date;
    /**
     * 头像地址
     */
    private String user_image;

    public Unit_user(String user_account, String user_password, String user_name, String user_date) {
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_date = user_date;
    }
    public Unit_user(){}
}
