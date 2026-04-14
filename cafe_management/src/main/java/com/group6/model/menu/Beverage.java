package com.group6.model.menu;

import com.group6.util.BeverageType;
import com.group6.util.Customization;
import com.group6.util.CustomizationType;
import com.group6.util.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Beverage extends MenuItem {
    private BeverageType type;
    private Map<Size, Double> sizeModifiers;
    private List<CustomizationType> availableCustomizations;

    public Beverage(String id, String name, double basePrice, BeverageType type) {
        super(id, name, basePrice);
        this.type = type;
        this.availableCustomizations = new ArrayList<>();
    }

    public double getPriceForSize(Size size) {
        if (sizeModifiers == null || sizeModifiers.isEmpty() || size == null) {
            return basePrice;
        }

        Double modifier = sizeModifiers.get(size);
        if (modifier == null) {
            return basePrice;
        }

        return basePrice * modifier;
    }

    public double calculateCustomizationCost(List<Customization> customizations) {
        double totalCost = 0;
        if (customizations == null || customizations.isEmpty()) {
            return totalCost;
        }

        for (Customization customization : customizations) {
            if (customization != null && (availableCustomizations == null
                    || availableCustomizations.contains(customization.getType()))) {
                totalCost += customization.getCost();
            }
        }
        return totalCost;
    }

    @Override
    public double calculatePrice(Size size, List<Customization> customizations) {
        return getPriceForSize(size) + calculateCustomizationCost(customizations);
    }

    public BeverageType getType() {
        return type;
    }

    public void setType(BeverageType type) {
        this.type = type;
    }

    public Map<Size, Double> getSizeModifiers() {
        return sizeModifiers;
    }

    public void setSizeModifiers(Map<Size, Double> sizeModifiers) {
        this.sizeModifiers = sizeModifiers;
    }

    public List<CustomizationType> getAvailableCustomizations() {
        return availableCustomizations;
    }

    public void setAvailableCustomizations(List<CustomizationType> availableCustomizations) {
        this.availableCustomizations = availableCustomizations;
    }
}
