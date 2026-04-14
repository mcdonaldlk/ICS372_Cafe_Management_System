package com.group6.view;

import com.group6.model.menu.MenuItem;
import com.group6.model.order.Order;
import com.group6.util.Ingredient;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Map;

public class ManagerView {
    private TabPane mainTabPane;
    private TableView<MenuItem> menuTableView;
    private TableView<Ingredient> inventoryTableView;
    private TableView<Order> fulfilledOrdersView;
    private Button addMenuItemButton;
    private Button restockButton;

    public ManagerView() {
        // TODO: Initialize UI components
    }

    public void refreshMenu(List<MenuItem> menuItems) {
        // TODO: Implement refresh menu
    }

    public void refreshInventory(Map<Ingredient, Integer> inventory) {
        // TODO: Implement refresh inventory
    }

    public void refreshFulfilledOrders(List<Order> orders) {
        // TODO: Implement refresh fulfilled orders
    }

    public void showAddMenuItemDialog() {
        // TODO: Implement show add menu item dialog
    }

    public TabPane getMainTabPane() {
        return mainTabPane;
    }

    public void setMainTabPane(TabPane mainTabPane) {
        this.mainTabPane = mainTabPane;
    }

    public TableView<MenuItem> getMenuTableView() {
        return menuTableView;
    }

    public void setMenuTableView(TableView<MenuItem> menuTableView) {
        this.menuTableView = menuTableView;
    }

    public TableView<Ingredient> getInventoryTableView() {
        return inventoryTableView;
    }

    public void setInventoryTableView(TableView<Ingredient> inventoryTableView) {
        this.inventoryTableView = inventoryTableView;
    }

    public TableView<Order> getFulfilledOrdersView() {
        return fulfilledOrdersView;
    }

    public void setFulfilledOrdersView(TableView<Order> fulfilledOrdersView) {
        this.fulfilledOrdersView = fulfilledOrdersView;
    }

    public Button getAddMenuItemButton() {
        return addMenuItemButton;
    }

    public void setAddMenuItemButton(Button addMenuItemButton) {
        this.addMenuItemButton = addMenuItemButton;
    }

    public Button getRestockButton() {
        return restockButton;
    }

    public void setRestockButton(Button restockButton) {
        this.restockButton = restockButton;
    }
}
