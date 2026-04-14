package com.group6.model.menu;

import com.group6.util.Customization;
import com.group6.util.Ingredient;
import com.group6.util.Size;

import java.util.List;
import java.util.Map;

public abstract class MenuItem {
    protected String id;
    protected String name;
    protected double basePrice;
    protected boolean available;
    protected Map<Ingredient, Double> ingredientRequirements;

    public MenuItem(String id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.available = true;
    }

    public abstract double calculatePrice(Size size, List<Customization> customizations);

    public boolean checkIngredientAvailability() {
        // TODO: Implement check ingredient availability
        return false;
    }

    public void consumeIngredients() {
        // TODO: Implement consume ingredients
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Map<Ingredient, Double> getIngredientRequirements() {
        return ingredientRequirements;
    }

    public void setIngredientRequirements(Map<Ingredient, Double> ingredientRequirements) {
        this.ingredientRequirements = ingredientRequirements;
    }
}
