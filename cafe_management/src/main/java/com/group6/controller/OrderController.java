package com.group6.controller;

import com.group6.model.inventory.InventoryManager;
import com.group6.model.menu.MenuItem;
import com.group6.model.order.Order;
import com.group6.model.order.OrderQueue;
import com.group6.model.user.Customer;
import com.group6.util.Customization;
import com.group6.util.OrderStatus;
import com.group6.util.Size;
import com.group6.view.CustomerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    private OrderQueue orderQueue;
    private InventoryManager inventoryManager;
    private Customer currentCustomer;
    private CustomerView customerView;

    public OrderController() {
        this.orderQueue = new OrderQueue();
        this.inventoryManager = InventoryManager.getInstance();
    }

    public boolean addItemToOrder(MenuItem menuItem, int quantity, Size size, List<Customization> customizations) {
        if (menuItem == null || quantity <= 0) {
            return false;
        }

        Map<com.group6.util.Ingredient, Double> scaledRequirements = new HashMap<>();
        if (menuItem.getIngredientRequirements() != null) {
            for (Map.Entry<com.group6.util.Ingredient, Double> entry : menuItem.getIngredientRequirements().entrySet()) {
                scaledRequirements.put(entry.getKey(), entry.getValue() * quantity);
            }
        }

        if (!inventoryManager.checkAvailability(scaledRequirements)) {
            return false;
        }

        return inventoryManager.deductIngredients(scaledRequirements);
    }

    public void placeOrder() {
        // Order persistence/UI wiring can be added once the customer cart is connected.
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

    public CustomerView getOrderView() {
        return customerView;
    }

    public void setOrderView(CustomerView orderView) {
        this.customerView = orderView;
    }
}
