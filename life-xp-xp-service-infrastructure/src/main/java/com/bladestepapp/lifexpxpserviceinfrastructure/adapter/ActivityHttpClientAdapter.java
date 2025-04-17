package com.bladestepapp.lifexpxpserviceinfrastructure.adapter;

import com.bladestepapp.lifexpxpservicecore.domain.Activity;
import com.bladestepapp.lifexpxpservicecore.port.gateway.GetActivityPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.adapter.mapper.ActivityMapper;
import com.bladestepapp.lifexpxpserviceinfrastructure.gateway.ActivityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ActivityHttpClientAdapter implements GetActivityPort {

    private final ActivityGateway activityGateway;

    private final ActivityMapper mapper;

    @Override
    public Optional<Activity> find(UUID id) {
        return activityGateway.find(id).map(mapper::map);
    }
}
