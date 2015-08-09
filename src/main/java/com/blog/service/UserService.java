package com.blog.service;

import com.blog.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User getUserByUsername(String userName);
    void saveUser(User user);
    void deleteUser(User user);
    Iterable<User> getAllUsers();
}
