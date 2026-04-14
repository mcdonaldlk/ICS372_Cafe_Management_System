package com.group6.model.order;

import com.group6.model.menu.MenuItem;
import com.group6.util.Customization;
import com.group6.util.Size;

import java.util.List;

public class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    private Size size;
    private List<Customization> customizations;
    private double unitPrice;

    public OrderItem(MenuItem menuItem, int quantity, Size size, List<Customization> customizations) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.size = size;
        this.customizations = customizations;
        this.unitPrice = 0;
    }

    public double calculateItemPrice() {
        if (menuItem == null) {
            unitPrice = 0;
            return 0;
        }

        unitPrice = menuItem.calculatePrice(size, customizations);
        return unitPrice * quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<Customization> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<Customization> customizations) {
        this.customizations = customizations;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
