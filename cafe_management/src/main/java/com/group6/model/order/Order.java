package com.group6.model.order;

import com.group6.util.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private LocalDateTime orderTime;
    private List<OrderItem> items;
    private OrderStatus status;
    private double totalPrice;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderTime = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
        this.totalPrice = 0;
    }

    public boolean addItem(OrderItem item) {
        
        if (item == null || 
            item.getMenuItem() == null || 
            items == null) {
            return false;
        }
        items.add(item);
        return true;
    }

    public void removeItem(String itemId) {
        if (items == null) {
            return;
        }
        items.removeIf(item -> item.getMenuItem() != null 
                        && item.getMenuItem().getId().equals(itemId));
    }

    public double calculateTotal() {
        double total = 0;
        if (items != null && !items.isEmpty()) {
            for (OrderItem item : items) {
                total += item.calculateItemPrice();
            }
            return total;
        }
        return 0;
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
