package com.group6.controller;

import com.group6.model.inventory.InventoryManager;
import com.group6.model.menu.MenuItem;
import com.group6.model.order.Order;
import com.group6.model.order.OrderQueue;
import com.group6.model.user.Customer;
import com.group6.util.Customization;
import com.group6.util.OrderStatus;
import com.group6.util.Size;
import com.group6.view.CustomerOrderView;

import java.util.List;

public class OrderController {
    private OrderQueue orderQueue;
    private InventoryManager inventoryManager;
    private Customer currentCustomer;
    private CustomerOrderView orderView;

    public OrderController(OrderQueue orderQueue, InventoryManager inventoryManager) {
        this.orderQueue = orderQueue;
        this.inventoryManager = inventoryManager;
        this.currentCustomer = null;
        this.orderView = null;
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

    public void updateOrderStatus(Order order, OrderStatus status) {
        // TODO: Implement update order status
    }

    public void completeOrder(Order order) {
        // TODO: Implement complete order
    }

    public OrderQueue getOrderQueue() {
        return orderQueue;
    }

    public void setOrderQueue(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public CustomerOrderView getOrderView() {
        return orderView;
    }

    public void setOrderView(CustomerOrderView orderView) {
        this.orderView = orderView;
    }
}
