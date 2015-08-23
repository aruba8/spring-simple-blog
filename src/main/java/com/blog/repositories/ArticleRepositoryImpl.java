package com.blog.repositories;

import com.blog.model.Article;
import com.blog.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
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
    public List<Article> findAll(int last) {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Article.class).addOrder(Order.desc("dateTime")).setMaxResults(last).list();
    }

    @Override
    public void save(Article article) throws ConstraintViolationException{
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            session.save(article);
        } catch (ConstraintViolationException e){
            throw e;
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Article> findAllByTag(Tag tag) {
        Session session = sessionFactory.openSession();
        String hql = "select a from Article as a inner join a.tags as t where t.name = ? order by a.dateTime desc";
        List<Article> articles = session.createQuery(hql).setString(0, tag.getName()).list();
        return articles;
    }
}
