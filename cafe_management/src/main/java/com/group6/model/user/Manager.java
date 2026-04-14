package com.group6.model.user;

import com.group6.model.menu.MenuItem;
import com.group6.model.order.Order;
import com.group6.util.Ingredient;
import com.group6.util.UserRole;

import java.util.List;
import java.util.Map;

public class Manager extends User {

    public Manager(String username, String password) {
        super(username, password, UserRole.MANAGER);
    }

    public Map<Ingredient, Integer> viewInventory() {
        // TODO: Implement view inventory
        return null;
    }

    public void restockIngredient(Ingredient ingredient, int quantity) {
        // TODO: Implement restock ingredient
    }

    public void addMenuItem(MenuItem menuItem) {
        // TODO: Implement add menu item
    }

    public void modifyMenuItem(MenuItem menuItem) {
        // TODO: Implement modify menu item
    }

    public void removeMenuItem(String menuItemId) {
        // TODO: Implement remove menu item
    }

    public List<Order> getFulfilledOrders() {
        // TODO: Implement get fulfilled orders
        return null;
    }
}
