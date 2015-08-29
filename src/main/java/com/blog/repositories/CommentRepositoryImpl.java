package com.blog.repositories;

import com.blog.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Comment comment) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(comment);
        session.getTransaction().commit();
    }
}
