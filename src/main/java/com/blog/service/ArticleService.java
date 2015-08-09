package com.blog.service;

import com.blog.model.Article;

import java.util.List;

public interface ArticleService {
    Article getArticleById(Long id);
    Article getArticleByPermalink(String permalink);
    List<Article> getArticleList();
    void saveArticle(Article article);
    void updateArticle(Long id, Article article);
    void deleteArticle(Long id);
}
