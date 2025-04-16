package com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model;

import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.enums.ActivityCategory;
import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.enums.ActivityUnit;

public class ActivityResponseModel {

    private String name;

    private String description;

    private ActivityCategory category;

    private ActivityUnit unit;

    private double baseXp;
}