package com.blog.repositories;

import com.blog.model.Article;

import java.util.List;

public interface ArticleRepository {
    Article findById(Long id);
    Article findByPermalink(String permalink);
    List<Article> findAll();
}
