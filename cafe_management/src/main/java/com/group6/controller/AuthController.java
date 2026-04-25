package com.group6.controller;

import java.util.ArrayList;
import java.util.List;

import com.group6.model.user.User;
import com.group6.model.user.Barista;
import com.group6.model.user.Customer;
import com.group6.model.user.Manager;
import com.group6.util.UserRole;

public class AuthController {
    private MainController mainController;
    private List<User> registeredUsers;
    
    public AuthController(MainController mainController) {
        this.mainController = mainController;
        this.registeredUsers = new ArrayList<>();
        initializeUsers();
    }
    
    private void initializeUsers() {
        // Hardcoded users as per requirements
        registeredUsers.add(new Barista("barista", "barista123"));
        registeredUsers.add(new Manager("manager", "manager123"));
    }
    
    public void handleCustomerLogin(String name) {
        Customer customer = new Customer(name);
        mainController.switchToCustomerView(customer);
    }
    
    public boolean handleBaristaLogin(String username, String password) {
        User user = authenticateUser(username, password, UserRole.BARISTA);
        if (user instanceof Barista) {
            mainController.switchToBaristaView((Barista) user);
            return true;
        }
        return false;
    }
    
    public boolean handleManagerLogin(String username, String password) {
        User user = authenticateUser(username, password, UserRole.MANAGER);
        if (user instanceof Manager) {
            mainController.switchToManagerView((Manager) user);
            return true;
        }
        return false;
    }
    
    private User authenticateUser(String username, String password, UserRole role) {
        return registeredUsers.stream()
            .filter(user -> user.getRole() == role)
            .filter(user -> user.login(username, password))
            .findFirst()
            .orElse(null);
    }
    
    public void logout() {
        mainController.logout();
    }
    
}
