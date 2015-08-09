package com.blog.service;

import com.blog.model.Role;
import com.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);

        Set<GrantedAuthority> roles = getGrantedAuthorities(user.getRoles());
        org.springframework.security.core.userdetails.User userSpring =  new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                roles);
        return userSpring;
    }


    public static Set<GrantedAuthority> getGrantedAuthorities(Set<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

}
