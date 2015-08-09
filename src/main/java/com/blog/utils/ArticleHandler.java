package com.blog.utils;

import com.blog.model.Article;

public interface ArticleHandler {
    Article prepareArticle(String rawArticle);
}
