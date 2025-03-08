package com.bladestepapp.lifexpxpserviceinfrastructure.mappers;

import com.bladestepapp.lifexpxpservicecore.domain.Activity;
import com.bladestepapp.model.ActivityResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityResponseMapper {

    Activity map(ActivityResponse activityResponse);
}
