package com.group6.model.order;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> pendingOrders;
    private List<Order> fulfilledOrders;
    private int nextOrderId;

    public OrderQueue() {
        this.pendingOrders = new LinkedList<>();
        this.fulfilledOrders = new LinkedList<>();
        this.nextOrderId = 1;
    }

    public void addOrder(Order order) {
        if (order != null) {
            order.setId(nextOrderId++);
            pendingOrders.offer(order);
        }

    }

    public Order getNextOrder() {
        if (pendingOrders.isEmpty()) {
            return null;
        }
        return pendingOrders.poll();
    }

    public List<Order> getPendingOrders() {
        return new LinkedList<>(pendingOrders);
    }

    public void markFulfilled(Order order) {
        if (order != null) {
            fulfilledOrders.add(order);
        }
    }

    public Queue<Order> getQueue() {
        return pendingOrders;
    }

    public List<Order> getFulfilledOrders() {
        return fulfilledOrders;
    }

    public int getNextOrderId() {
        return nextOrderId;
    }

    public void setNextOrderId(int nextOrderId) {
        this.nextOrderId = nextOrderId;
    }
}
