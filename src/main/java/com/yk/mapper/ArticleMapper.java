package com.yk.mapper;

import com.yk.bean.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: chaizi
 */
@Mapper
public interface ArticleMapper {
    //void saveArticle(Article article);
    List<Article> getAllArticle();

    void saveArticle(Article article);

    void deleteArticle(Integer id);

    Article findArticleById(Integer id);

    void updateArticle(Article article);

}
