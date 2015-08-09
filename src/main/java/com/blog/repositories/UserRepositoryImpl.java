package com.blog.repositories;

import com.blog.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        return (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
    }
}
