package com.group6.controller;

import com.group6.model.menu.MenuItem;
import com.group6.pattern.factory.BeverageFactory;
import com.group6.pattern.factory.PastryFactory;
import com.group6.util.BeverageType;
import com.group6.util.PastryType;
import com.group6.util.PastryVariety;
import com.group6.view.ManagerView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private MenuCatalog menuCatalog;
    private ManagerView managerView;

    public MenuController() {
        this.menuCatalog = null;
        this.managerView = null;
    }


    public List<MenuItem> getAvailableBeverages() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new BeverageFactory("bev1", "Espresso", "Single shot espresso", 2.50, BeverageType.COFFEE).orderMenuItem());
        list.add(new BeverageFactory("bev2", "Latte", "Espresso with milk", 3.50, BeverageType.COFFEE).orderMenuItem());
        return list;
    }

    public List<MenuItem> getAvailablePastries() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new PastryFactory("pst1", "Croissant", "Buttery croissant", 2.00, PastryType.CROISSANT, PastryVariety.PLAIN, 0).orderMenuItem());
        list.add(new PastryFactory("pst2", "Chocolate Muffin", "Muffin with chocolate chips", 2.50, PastryType.MUFFIN, PastryVariety.CHOCOLATE, 0).orderMenuItem());
        return list;
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
