package com.bladestepapp.lifexpxpservicecore.command;

import lombok.Value;

import java.util.UUID;

@Value
public class CreateXpRecordCommand {

    UUID userId;

    UUID activityId;

    Integer unitCount;
}
