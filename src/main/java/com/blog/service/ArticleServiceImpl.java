package com.blog.service;

import com.blog.model.Article;
import com.blog.model.Tag;
import com.blog.repositories.ArticleRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }


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
    public List<Article> getArticleListAndSkip(int pageSize, int page) {
        return articleRepository.findAllAndSkip(pageSize, page);
    }

    @Override
    public List<Article> getArticlesByTag(Tag tag) {
        return articleRepository.findAllByTag(tag);
    }

    @Override
    public void saveArticle(Article article) throws ConstraintViolationException{
        articleRepository.save(article);
    }

    @Override
    public int getMaxNumberOfPages(int articlesPerPage) {
        int numberOfArticles = articleRepository.findAll().size();
        if (numberOfArticles%articlesPerPage == 0){
            return numberOfArticles/articlesPerPage;
        } else {
            return numberOfArticles/articlesPerPage+1;
        }
    }

    @Override
    public void updateArticle(Long id, Article article) {

    }

    @Override
    public void deleteArticle(Long id) {

    }
}
