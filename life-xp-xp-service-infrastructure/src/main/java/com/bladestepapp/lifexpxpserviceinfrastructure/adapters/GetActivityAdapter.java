package com.bladestepapp.lifexpxpserviceinfrastructure.adapters;

import com.bladestepapp.api.ActivitiesApiClient;
import com.bladestepapp.lifexpxpservicecore.domain.Activity;
import com.bladestepapp.lifexpxpservicecore.ports.GetActivityPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.mappers.ActivityResponseMapper;
import com.bladestepapp.model.ActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetActivityAdapter implements GetActivityPort {

    private final ActivitiesApiClient activitiesApiClient;

    private final ActivityResponseMapper mapper;

    @Override
    public Activity get(UUID id) {
        ActivityResponse activityResponse = activitiesApiClient.getActivityById(id).getBody();
        return mapper.map(activityResponse);
    }
}
