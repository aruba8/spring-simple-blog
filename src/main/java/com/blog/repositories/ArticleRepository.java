package com.blog.repositories;

import com.blog.model.Article;
import com.blog.model.Tag;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public interface ArticleRepository {
    Article findById(Long id);
    Article findByPermalink(String permalink);
    List<Article> findAll();
    List<Article> findAllAndSkip(int pageSize, int page);
    void save(Article article) throws ConstraintViolationException;
    List<Article> findAllByTag(Tag tag);
}
