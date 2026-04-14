package com.group6.controller;

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

    public void switchToCustomerView() {
        // TODO: Implement switch to customer view
    }

    public void switchToBaristaView() {
        // TODO: Implement switch to barista view
    }

    public void switchToManagerView() {
        // TODO: Implement switch to manager view
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

    public AuthController getAuthController() {
        return authController;
    }

    public void setAuthController(AuthController authController) {
        this.authController = authController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public InventoryController getInventoryController() {
        return inventoryController;
    }

    public void setInventoryController(InventoryController inventoryController) {
        this.inventoryController = inventoryController;
    }
}
