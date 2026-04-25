package com.group6.view;

import com.group6.model.order.Order;
import com.group6.util.OrderStatus;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.List;

public class BaristaView implements View {
    private ListView<Order> ordersListView;
    private Button updateStatusButton;
    private Button completeButton;
    private ComboBox<OrderStatus> statusSelector;

    public BaristaView() {
        // TODO: Initialize UI components
    }

    public void refreshOrders(List<Order> orders) {
        // TODO: Implement refresh orders
    }

    public void showOrderDetails(Order order) {
        // TODO: Implement show order details
    }

    public void updateOrderStatus(Order order) {
        // TODO: Implement update order status
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
