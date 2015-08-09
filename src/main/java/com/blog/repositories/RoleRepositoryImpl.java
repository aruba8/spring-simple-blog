package com.blog.repositories;

import com.blog.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRole(Long id) {
        Session session = sessionFactory.openSession();
        return (Role) session.load(Role.class, id);
    }
}
