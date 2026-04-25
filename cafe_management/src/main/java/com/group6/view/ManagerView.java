package com.group6.view;

import com.group6.model.menu.MenuItem;
import com.group6.model.order.Order;
import com.group6.util.Ingredient;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Map;

public class ManagerView implements View {
    private TabPane mainTabPane;
    private TableView<MenuItem> menuTableView;
    private TableView<Ingredient> inventoryTableView;
    private TableView<Order> fulfilledOrdersView;
    private Button addMenuItemButton;
    private Button restockButton;

    public ManagerView() {
        // TODO: Initialize UI components
    }

    @Override
    public Parent getView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getView'");
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refresh'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

    @Override
    public void displayErrorMessage(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayErrorMessage'");
    }

    @Override
    public void clearMessages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearMessages'");
    }
}
