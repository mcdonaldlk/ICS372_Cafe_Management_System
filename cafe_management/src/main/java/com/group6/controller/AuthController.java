package com.group6.controller;

import com.group6.model.user.User;
import com.group6.view.LoginView;

public class AuthController {
    private User currentUser;
    private LoginView loginView;
    private MainController mainController;

    public AuthController(LoginView loginView) {
        this.loginView = loginView;
        this.currentUser = null;
    }

    public void handleCustomerLogin(String username) {
        // TODO: Implement customer login
    }

    public boolean handleBaristaLogin(String username, String password) {
        // TODO: Implement barista login
        return false;
    }

    public boolean handleManagerLogin(String username, String password) {
        // TODO: Implement manager login
        return false;
    }

    public void logout() {
        // TODO: Implement logout
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
