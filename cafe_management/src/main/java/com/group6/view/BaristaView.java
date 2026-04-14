package com.group6.view;

import com.group6.model.order.Order;
import com.group6.util.OrderStatus;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.List;

public class BaristaView {
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

    public ListView<Order> getOrdersListView() {
        return ordersListView;
    }

    public void setOrdersListView(ListView<Order> ordersListView) {
        this.ordersListView = ordersListView;
    }

    public Button getUpdateStatusButton() {
        return updateStatusButton;
    }

    public void setUpdateStatusButton(Button updateStatusButton) {
        this.updateStatusButton = updateStatusButton;
    }

    public Button getCompleteButton() {
        return completeButton;
    }

    public void setCompleteButton(Button completeButton) {
        this.completeButton = completeButton;
    }

    public ComboBox<OrderStatus> getStatusSelector() {
        return statusSelector;
    }

    public void setStatusSelector(ComboBox<OrderStatus> statusSelector) {
        this.statusSelector = statusSelector;
    }
}
