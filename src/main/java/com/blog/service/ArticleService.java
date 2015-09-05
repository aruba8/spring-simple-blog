package com.blog.service;

import com.blog.model.Article;
import com.blog.model.Tag;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public interface ArticleService {
    Article getArticleById(Long id);
    Article getArticleByPermalink(String permalink);
    List<Article> getArticleList();
    List<Article> getArticleListAndSkip(int pageSize, int page);
    List<Article> getArticlesByTag(Tag tag);
    void saveArticle(Article article) throws ConstraintViolationException;
    int getMaxNumberOfPages(int articlesPerPage);
    void updateArticle(Long id, Article article);
    void deleteArticle(Long id);

}
