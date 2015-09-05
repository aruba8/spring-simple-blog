package com.blog.service;

import com.blog.model.Article;
import com.blog.repositories.ArticleRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public class TestArticleService {

    @Mock
    ArticleRepository articleRepository;
    ArticleService articleService;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        articleService = new ArticleServiceImpl(articleRepository);
        Article article = new Article();
        article.setTitle("Title");
        article.setArticleBody("Article body");
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        when(articleRepository.findAll()).thenReturn(articles);
    }

    @Test
    public void testSmth(){
        articleService = new ArticleServiceImpl(articleRepository);
        List<Article> articleList = articleService.getArticleList();
        Assert.assertEquals(articleList.size(), 1);
    }


    @Test
    public void testGetMaxNumberOfPages(){
        int maxNUmber = articleService.getMaxNumberOfPages(10);
        Assert.assertEquals(maxNUmber, 1);

    }


}
