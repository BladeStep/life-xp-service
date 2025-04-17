package com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model;

import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.enums.ActivityCategory;
import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.enums.ActivityUnit;

public class ActivityResponseModel {

    public ActivityResponseModel(String name, String description, ActivityCategory category, ActivityUnit unit, double baseXp) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.unit = unit;
        this.baseXp = baseXp;
    }

    private String name;

    private String description;

    private ActivityCategory category;

    private ActivityUnit unit;

    private double baseXp;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ActivityCategory getCategory() {
        return category;
    }

    public ActivityUnit getUnit() {
        return unit;
    }

    public double getBaseXp() {
        return baseXp;
    }
}