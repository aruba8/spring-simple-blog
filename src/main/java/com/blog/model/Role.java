package com.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rolename", unique = true)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
//    @JoinTable(name = "user_roles",
//            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> users;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUserRoles() {
        return users;
    }

    public void setUserRoles(Set<User> userRoles) {
        this.users = userRoles;
    }

    public Long getId() {
        return id;
    }
}
