package com.yk.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: chaizi
 */
@Data
public class Article {

    private int id;
    /**
     * 标题
     */
    private String title;
    /**
     * 正文
     */
    private String content;
    /**
     * 作者
     */
    private int userId;
    /**
     * 创建日期
     */
    private String createDate;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 阅读量
     */
    private int readCount = 0;


}
