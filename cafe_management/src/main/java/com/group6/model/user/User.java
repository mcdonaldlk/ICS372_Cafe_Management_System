package com.group6.model.user;

import com.group6.util.UserRole;

public abstract class User {
    protected String username;
    protected String password;
    protected UserRole role;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login(String username, String password) {
        if(username != null && password != null) {
            return this.username.equals(username.trim()) && this.password.equals(password.trim());
        }
        return false;
    }

    public UserRole getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
