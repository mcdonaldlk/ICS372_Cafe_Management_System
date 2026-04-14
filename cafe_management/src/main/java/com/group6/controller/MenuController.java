package com.group6.controller;

import com.group6.model.menu.Beverage;
import com.group6.model.menu.MenuItem;
import com.group6.model.menu.Pastry;
import com.group6.view.ManagerView;

import java.util.List;

public class MenuController {
    private MenuCatalog menuCatalog;
    private ManagerView managerView;

    public MenuController(MenuCatalog menuCatalog) {
        this.menuCatalog = menuCatalog;
        this.managerView = null;
    }

    public List<MenuItem> getAllMenuItems() {
        // TODO: Implement get all menu items
        return null;
    }

    public List<Beverage> getAvailableBeverages() {
        // TODO: Implement get available beverages
        return null;
    }

    public List<Pastry> getAvailablePastries() {
        // TODO: Implement get available pastries
        return null;
    }

    public void addMenuItem(MenuItem menuItem) {
        // TODO: Implement add menu item
    }

    public void updateMenuItem(MenuItem menuItem) {
        // TODO: Implement update menu item
    }

    public void deleteMenuItem(String menuItemId) {
        // TODO: Implement delete menu item
    }

    public void refreshMenuView() {
        // TODO: Implement refresh menu view
    }

    public MenuCatalog getMenuCatalog() {
        return menuCatalog;
    }

    public void setMenuCatalog(MenuCatalog menuCatalog) {
        this.menuCatalog = menuCatalog;
    }

    public ManagerView getManagerView() {
        return managerView;
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }
}
