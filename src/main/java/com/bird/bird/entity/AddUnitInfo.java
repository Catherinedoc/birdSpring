package com.bird.bird.entity;

import java.io.File;
import java.util.Date;

public class AddUnitInfo {
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
     * 是否启用，true代表启用，false代表禁用
     */
    private boolean use;
    /**
     * 创建日期
     */
    private Date user_date;
    /**
     * 头像地址
     */
    private File user_image;
}
