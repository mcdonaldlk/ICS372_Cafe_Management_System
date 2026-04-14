package com.group6.model.user;

import com.group6.model.order.Order;
import com.group6.util.OrderStatus;
import com.group6.util.UserRole;

import java.util.List;

public class Barista extends User {

    public Barista(String username, String password) {
        super(username, password, UserRole.BARISTA);
    }

    public List<Order> getPendingOrders() {
        // TODO: Implement get pending orders
        return null;
    }

    public void updateOrderStatus(Order order, OrderStatus status) {
        // TODO: Implement update order status
    }

    public void completeOrder(Order order) {
        // TODO: Implement complete order
    }
}
