package com.bladestepapp.lifexpxpserviceinfrastructure.gateway.mapper;

import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.model.ActivityResponseModel;
import com.bladestepapp.model.ActivityResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityGatewayMapper {

    ActivityResponseModel map(ActivityResponseDto activityResponseDto);
}