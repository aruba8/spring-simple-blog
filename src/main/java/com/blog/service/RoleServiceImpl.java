package com.blog.service;

import com.blog.model.Role;
import com.blog.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRole(Long id) {
        return roleRepository.getRole(id);
    }
}
