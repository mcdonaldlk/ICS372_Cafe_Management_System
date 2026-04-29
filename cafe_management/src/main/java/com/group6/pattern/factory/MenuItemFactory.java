package com.group6.pattern.factory;

import com.group6.model.menu.MenuItem;
import com.group6.model.menu.Beverage;
import com.group6.model.menu.Pastry;

public abstract class MenuItemFactory {
    

    public abstract MenuItem createMenuItem();

    public MenuItem orderMenuItem() {
        MenuItem item = createMenuItem();
        prepareItem(item);
        validateItem(item);
        return item;
    }
    

    protected void prepareItem(MenuItem item) {
        item.setAvailable(true);
    }
    
    protected void validateItem(MenuItem item) {
        if (item.getId() == null || item.getId().isEmpty()) {
            throw new IllegalStateException("MenuItem must have an ID");
        }
        if (item.getName() == null || item.getName().isEmpty()) {
            throw new IllegalStateException("MenuItem must have a name");
        }
        if (item.getBasePrice() < 0) {
            throw new IllegalStateException("MenuItem price cannot be negative");
        }
    }
}