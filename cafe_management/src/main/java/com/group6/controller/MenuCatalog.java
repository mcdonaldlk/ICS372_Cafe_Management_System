package com.group6.controller;

import com.group6.model.menu.MenuItem;

import java.util.List;
import java.util.Map;

public class MenuCatalog {
    private Map<String, MenuItem> menuItems;

    public MenuCatalog() {
        // TODO: Initialize menu catalog
    }

    public void loadFromJSON(String filePath) {
        // TODO: Implement load from JSON
    }

    public List<MenuItem> getAllItems() {
        // TODO: Implement get all items
        return null;
    }

    public MenuItem getItemById(String itemId) {
        // TODO: Implement get item by id
        return null;
    }

    public void addItem(MenuItem menuItem) {
        // TODO: Implement add item
    }

    public void updateItem(MenuItem menuItem) {
        // TODO: Implement update item
    }

    public void removeItem(String itemId) {
        // TODO: Implement remove item
    }

    public Map<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Map<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
