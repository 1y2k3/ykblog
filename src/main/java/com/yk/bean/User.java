package com.yk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int id;
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private int sex;
    /**
     * 真实姓名
     */
    private String nickName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

    private Date createDate;

    private Date createTime;

}
