package com.blog.repositories;

import com.blog.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Article findById(Long id) {
        Session session = sessionFactory.openSession();
        return (Article) session.get(Article.class, id);
    }

    @Override
    public Article findByPermalink(String permalink) {
        Session session = sessionFactory.openSession();
        return (Article) session.createCriteria(Article.class).add(Restrictions.eq("permalink", permalink)).uniqueResult();
    }

    @Override
    public List<Article> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Article.class).addOrder(Order.desc("dateTime")).list();
    }
}
