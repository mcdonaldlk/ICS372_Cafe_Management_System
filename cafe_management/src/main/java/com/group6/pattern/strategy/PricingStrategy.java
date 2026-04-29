package com.group6.pattern.strategy;

public interface PricingStrategy {
    double calculatePrice(double basePrice);
    String getStrategyName();
}
