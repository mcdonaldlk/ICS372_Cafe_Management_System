package com.group6.controller;

import com.group6.model.user.Barista;
import com.group6.model.user.Customer;
import com.group6.model.user.Manager;
import com.group6.model.user.User;

public class MainController {
    private User currentUser;
    private AuthController authController;
    private OrderController orderController;
    private MenuController menuController;
    private InventoryController inventoryController;

    public MainController() {
        this.currentUser = null;
    }

    public void switchToCustomerView(Customer customer) {
        this.currentUser = customer;
    }

    public void switchToBaristaView(Barista barista) {
        this.currentUser = barista;
    }

    public void switchToManagerView(Manager user) {
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


}
