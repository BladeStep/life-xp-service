package com.bladestepapp.lifexpxpservicecore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateXpRecordResponseModel {

    private Integer dailyXpForCurrentActivity;

    private Integer dailyXpByAllActivities;
}