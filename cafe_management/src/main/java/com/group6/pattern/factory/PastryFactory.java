package com.group6.pattern.factory;

import com.group6.model.menu.MenuItem;
import com.group6.model.menu.Pastry;
import com.group6.util.Ingredient;
import com.group6.util.PastryType;
import com.group6.util.PastryVariety;

import java.util.HashMap;
import java.util.Map;

public class PastryFactory extends MenuItemFactory {
    private String id;
    private String name;
    private String description;
    private double basePrice;
    private PastryType type;
    private PastryVariety variety;
    
    public PastryFactory(String id, String name, String description, 
                        double basePrice, PastryType type, PastryVariety variety, 
                        int initialStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.type = type;
        this.variety = variety;
    }
    
    @Override
    public MenuItem createMenuItem() {
        Pastry pastry = new Pastry(id, name, basePrice, type, variety);
        pastry.setType(type);
        pastry.setVariety(variety);
        pastry.setIngredientRequirements(buildIngredientRequirements());
        return pastry;
    }

    private Map<Ingredient, Double> buildIngredientRequirements() {
        Map<Ingredient, Double> requirements = new HashMap<>();

        Ingredient flour = new Ingredient("ing-flour", "Flour", "grams");
        Ingredient butter = new Ingredient("ing-butter", "Butter", "grams");
        Ingredient sugar = new Ingredient("ing-sugar", "Sugar", "grams");
        Ingredient chocolateChips = new Ingredient("ing-choc-chips", "Chocolate Chips", "grams");

        if (type == PastryType.CROISSANT) {
            requirements.put(flour, 220.0);
            requirements.put(butter, 90.0);
            requirements.put(sugar, 10.0);
        } else if (type == PastryType.MUFFIN) {
            requirements.put(flour, 180.0);
            requirements.put(butter, 60.0);
            requirements.put(sugar, 20.0);
            if (variety == PastryVariety.CHOCOLATE) {
                requirements.put(chocolateChips, 50.0);
            }
        } else if (type == PastryType.COOKIE) {
            requirements.put(flour, 120.0);
            requirements.put(butter, 60.0);
            requirements.put(sugar, 35.0);
            if (variety == PastryVariety.CHOCOLATE) {
                requirements.put(chocolateChips, 40.0);
            }
        } else {
            requirements.put(flour, 150.0);
            requirements.put(butter, 50.0);
            requirements.put(sugar, 15.0);
        }

        return requirements;
    }
    
    public static class Builder {
        private String id;
        private String name;
        private String description;
        private double basePrice;
        private PastryType type;
        private PastryVariety variety;
        
        public Builder id(String id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder basePrice(double price) { this.basePrice = price; return this; }
        public Builder type(PastryType type) { this.type = type; return this; }
        public Builder variety(PastryVariety variety) { this.variety = variety; return this; }
        
        public PastryFactory build() {
            return new PastryFactory(id, name, description, basePrice, type, variety, 0);
        }
    }
}
