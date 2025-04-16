package com.bladestepapp.lifexpxpservicecore.port.gateway;

import com.bladestepapp.lifexpxpservicecore.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface GetUserPort {

    Optional<User> find(UUID id);
}