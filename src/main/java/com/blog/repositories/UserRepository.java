package com.blog.repositories;

import com.blog.model.User;

public interface UserRepository{
    User findByUsername(String username);
    void save(User user);
}
