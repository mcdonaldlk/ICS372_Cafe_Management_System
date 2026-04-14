package com.group6.model.menu;

import com.group6.util.BeverageType;
import com.group6.util.Customization;
import com.group6.util.Size;

import java.util.List;
import java.util.Map;

public class Beverage extends MenuItem {
    private BeverageType type;
    private Map<Size, Double> sizeModifiers;
    private List<Customization> availableCustomizations;

    public Beverage(String id, String name, double basePrice, BeverageType type) {
        super(id, name, basePrice);
        this.type = type;
    }

    public double getPriceForSize(Size size) {
        // TODO: Implement get price for size
        return 0;
    }

    public double calculateCustomizationCost(List<Customization> customizations) {
        // TODO: Implement calculate customization cost
        return 0;
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

    public List<Customization> getAvailableCustomizations() {
        return availableCustomizations;
    }

    public void setAvailableCustomizations(List<Customization> availableCustomizations) {
        this.availableCustomizations = availableCustomizations;
    }
}
