package com.group6.model.menu;

import com.group6.util.PastryType;
import com.group6.util.PastryVariety;

public class Pastry extends MenuItem {
    private PastryType type;
    private PastryVariety variety;

    public Pastry(String id, String name, double basePrice, PastryType type, PastryVariety variety) {
        super(id, name, basePrice);
        this.type = type;
        this.variety = variety;
    }

    public PastryType getType() {
        return type;
    }

    public void setType(PastryType type) {
        this.type = type;
    }

    public PastryVariety getVariety() {
        return variety;
    }

    public void setVariety(PastryVariety variety) {
        this.variety = variety;
    }
}
