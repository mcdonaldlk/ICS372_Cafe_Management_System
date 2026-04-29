package com.group6.controller;

import com.group6.model.inventory.InventoryManager;
import com.group6.util.Ingredient;
import com.group6.view.ManagerView;

import java.util.List;
import java.util.Map;

public class InventoryController {
    private InventoryManager inventoryManager;
    private ManagerView managerView;

    public InventoryController() {
        this.inventoryManager = InventoryManager.getInstance();
        this.managerView = null;
    }

    public Map<Ingredient, Integer> getCurrentInventory() {
        return inventoryManager.getInventory();
    }

    public void restockIngredient(Ingredient ingredient, int quantity) {
        inventoryManager.restock(ingredient, quantity);
    }

    public List<Ingredient> checkLowStock() {
        return inventoryManager.getLowStockItems();
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
