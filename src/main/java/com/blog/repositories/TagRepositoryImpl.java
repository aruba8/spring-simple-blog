package com.blog.repositories;

import com.blog.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class TagRepositoryImpl implements TagRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveAll(Set<Tag> tags) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        for (Tag tag : tags){
            session.save(tag);
        }
        session.getTransaction().commit();
    }

    @Override
    public void save(Tag tag) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(tag);
        session.getTransaction().commit();
    }
}
