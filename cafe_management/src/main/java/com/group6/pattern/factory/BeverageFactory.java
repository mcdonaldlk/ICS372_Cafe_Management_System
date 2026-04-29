package com.group6.pattern.factory;

import com.group6.model.menu.Beverage;
import com.group6.model.menu.MenuItem;
import com.group6.util.Ingredient;
import com.group6.util.BeverageType;

import java.util.HashMap;
import java.util.Map;

public class BeverageFactory extends MenuItemFactory {
    private String id;
    private String name;
    private String description;
    private double basePrice;
    private BeverageType type;
    
    public BeverageFactory(String id, String name, String description, double basePrice, BeverageType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.type = type;
    }
    
    @Override
    public MenuItem createMenuItem() {
        Beverage beverage = new Beverage(id, name, basePrice, type);
        beverage.setType(type);
        beverage.setIngredientRequirements(buildIngredientRequirements());
        return beverage;
    }

    private Map<Ingredient, Double> buildIngredientRequirements() {
        Map<Ingredient, Double> requirements = new HashMap<>();

        Ingredient coffeeBeans = new Ingredient("ing-coffee-beans", "Coffee Beans", "grams");
        Ingredient milk = new Ingredient("ing-milk", "Milk", "milliliters");
        Ingredient sugar = new Ingredient("ing-sugar", "Sugar", "grams");

        String normalizedName = name == null ? "" : name.trim().toLowerCase();
        switch (normalizedName) {
            case "espresso":
                requirements.put(coffeeBeans, 18.0);
                break;
            case "latte":
                requirements.put(coffeeBeans, 18.0);
                requirements.put(milk, 250.0);
                break;
            case "cappuccino":
                requirements.put(coffeeBeans, 18.0);
                requirements.put(milk, 180.0);
                break;
            case "mocha":
                requirements.put(coffeeBeans, 18.0);
                requirements.put(milk, 220.0);
                requirements.put(sugar, 10.0);
                break;
            default:
                requirements.put(coffeeBeans, 12.0);
                break;
        }

        return requirements;
    }
    
    // Builder pattern for cleaner construction
    public static class Builder {
        private String id;
        private String name;
        private String description;
        private double basePrice;
        private BeverageType type;
        
        public Builder id(String id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder basePrice(double price) { this.basePrice = price; return this; }
        public Builder type(BeverageType type) { this.type = type; return this; }
        
        public BeverageFactory build() {
            return new BeverageFactory(id, name, description, basePrice, type);
        }
    }
}
