package com.group6.controller;

import com.group6.model.inventory.InventoryManager;
import com.group6.util.Ingredient;
import com.group6.view.ManagerView;

import java.util.List;
import java.util.Map;

public class InventoryController {
    private InventoryManager inventoryManager;
    private ManagerView managerView;

    public InventoryController(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.managerView = null;
    }

    public Map<Ingredient, Integer> getCurrentInventory() {
        // TODO: Implement get current inventory
        return null;
    }

    public void restockIngredient(Ingredient ingredient, int quantity) {
        // TODO: Implement restock ingredient
    }

    public List<Ingredient> checkLowStock() {
        // TODO: Implement check low stock
        return null;
    }

    public void refreshInventoryView() {
        // TODO: Implement refresh inventory view
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public ManagerView getManagerView() {
        return managerView;
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }
}
