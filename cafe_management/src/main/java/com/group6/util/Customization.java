package com.group6.util;

public class Customization {
    private CustomizationType type;
    private double cost;

    public Customization(CustomizationType type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    public CustomizationType getType() {
        return type;
    }

    public void setType(CustomizationType type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Customization{" +
                "type=" + type +
                ", cost=" + cost +
                '}';
    }
}
