package com.blog.service;

import com.blog.model.Article;
import com.blog.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article getArticleByPermalink(String permalink) {
        return articleRepository.findByPermalink(permalink);
    }

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    public void saveArticle(Article article) {


    }

    @Override
    public void updateArticle(Long id, Article article) {

    }

    @Override
    public void deleteArticle(Long id) {

    }
}
