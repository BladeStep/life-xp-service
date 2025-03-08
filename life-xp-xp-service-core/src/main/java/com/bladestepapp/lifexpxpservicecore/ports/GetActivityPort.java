package com.bladestepapp.lifexpxpservicecore.ports;

import com.bladestepapp.lifexpxpservicecore.domain.Activity;

import java.util.UUID;

public interface GetActivityPort {

    Activity get(UUID id);
}
