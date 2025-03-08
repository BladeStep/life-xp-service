package com.bladestepapp.lifexpxpservicecore.domain;

import com.bladestepapp.lifexpxpservicecore.domain.enums.ActivityCategory;
import com.bladestepapp.lifexpxpservicecore.domain.enums.ActivityUnit;
import lombok.Data;

@Data
public class Activity {

    private String name;

    private String description;

    private ActivityCategory category;

    private ActivityUnit unit;

    private double baseXp;
}
