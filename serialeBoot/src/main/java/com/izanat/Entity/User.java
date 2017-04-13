package com.izanat.Entity;

import javax.persistence.*;

/**
 * Created by Nathalie on 08.04.2017.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "login", nullable = false, updatable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String passwordHash;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String login, String password, String email) {
        this.login = login;
        this.passwordHash = password;
        this.email = email;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password_hash) {
        this.passwordHash = password_hash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

