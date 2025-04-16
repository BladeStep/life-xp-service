package com.bladestepapp.lifexpxpserviceinfrastructure.adapter.mapper;

import com.bladestepapp.lifexpxpservicecore.domain.Activity;
import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.ActivityResponseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    Activity map(ActivityResponseModel activityResponseModel);
}