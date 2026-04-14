package com.group6.model.inventory;

import com.group6.util.Ingredient;

import java.util.List;
import java.util.Map;

public class InventoryManager {
    private Map<Ingredient, Integer> inventory;
    private Map<Ingredient, Integer> lowStockThreshold;

    public InventoryManager() {
        // TODO: Initialize inventory and thresholds
    }

    public void loadFromJSON(String filePath) {
        // TODO: Implement load from JSON
    }

    public boolean checkAvailability(Map<Ingredient, Double> requiredIngredients) {
        // TODO: Implement check availability
        return false;
    }

    public boolean deductIngredients(Map<Ingredient, Double> ingredients) {
        // TODO: Implement deduct ingredients
        return false;
    }

    public void restock(Ingredient ingredient, int quantity) {
        // TODO: Implement restock
    }

    public List<Ingredient> getLowStockItems() {
        // TODO: Implement get low stock items
        return null;
    }

    public Map<Ingredient, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Ingredient, Integer> inventory) {
        this.inventory = inventory;
    }

    public Map<Ingredient, Integer> getLowStockThreshold() {
        return lowStockThreshold;
    }

    public void setLowStockThreshold(Map<Ingredient, Integer> lowStockThreshold) {
        this.lowStockThreshold = lowStockThreshold;
    }
}
