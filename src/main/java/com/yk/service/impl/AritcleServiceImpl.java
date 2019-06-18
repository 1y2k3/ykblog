package com.yk.service.impl;

import com.yk.bean.Article;
import com.yk.bean.User;
import com.yk.mapper.ArticleMapper;
import com.yk.service.AritcleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;



/**
 * @Auther: chaizi
 */

@Service
@Slf4j
public class AritcleServiceImpl implements AritcleService {

    /**
     *
     */
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findAllArticle() {
        List<Article> articleList = articleMapper.getAllArticle();

        return articleList;
    }

    @Override
    public void addArticle(String title, String content,HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        Article article = new Article();

        article.setContent(content);
        article.setTitle(title);
        article.setUserId(userId);

        articleMapper.saveArticle(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);
    }

    @Override
    public Article showArticle(Integer id) {
        Article article = articleMapper.findArticleById(id);

        return article;
    }
}
