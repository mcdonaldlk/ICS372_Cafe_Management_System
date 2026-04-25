package com.group6.view;

import com.group6.model.menu.MenuItem;
import com.group6.model.order.Order;
import com.group6.model.order.OrderItem;
import com.group6.util.Size;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class CustomerOrderView implements View {
    private ComboBox<MenuItem> itemSelector;
    private ListView<MenuItem> catalogView;
    private ListView<OrderItem> orderCartView;
    private ComboBox<Size> sizeSelector;
    private ListView<Object> customizationSelector;
    private Label totalLabel;
    private Button addButton;
    private Button placeOrderButton;
    private Button clearButton;

    public CustomerOrderView() {
        // TODO: Initialize UI components
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

    @Override
    public Parent getView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getView'");
    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refresh'");
    }
}
