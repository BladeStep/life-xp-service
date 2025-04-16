package com.bladestepapp.lifexpxpservicecore.port.gateway;

import com.bladestepapp.lifexpxpservicecore.domain.Activity;

import java.util.Optional;
import java.util.UUID;

public interface GetActivityPort {

    Optional<Activity> find(UUID id);
}

