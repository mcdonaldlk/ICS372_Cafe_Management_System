package com.group6.model.user;

import com.group6.model.order.Order;
import com.group6.model.menu.MenuItem;
import com.group6.util.Customization;
import com.group6.util.Size;
import com.group6.util.UserRole;

import java.util.List;

public class Customer extends User {
    private String name;
    private Order currentOrder;

    public Customer(String username) {
        super(username, "", UserRole.CUSTOMER);
        this.name = username;
        this.currentOrder = null;
    }

    public void createNewOrder() {
        // TODO: Implement order creation
    }

    public boolean addItemToOrder(MenuItem menuItem, int quantity, Size size, List<Customization> customizations) {
        // TODO: Implement add item to order
        return false;
    }

    public void placeOrder() {
        // TODO: Implement place order
    }

    public void clearOrder() {
        // TODO: Implement clear order
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
