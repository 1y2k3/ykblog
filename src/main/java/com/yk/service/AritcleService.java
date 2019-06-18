package com.yk.service;

import com.yk.bean.Article;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: chaizi
 */
public interface AritcleService {
    List<Article> findAllArticle();

    void addArticle(String title,String content,HttpSession session);

    void deleteArticle(Integer id);

    Article showArticle(Integer id);
}
