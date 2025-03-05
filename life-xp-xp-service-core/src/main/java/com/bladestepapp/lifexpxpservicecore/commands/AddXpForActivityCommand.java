package com.bladestepapp.lifexpxpservicecore.commands;

import lombok.Value;

import java.util.UUID;

@Value
public class AddXpForActivityCommand {

    UUID userId;

    UUID activityId;

    Integer hours;
}
