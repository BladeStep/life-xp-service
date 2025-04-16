package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.util.UUID;

public interface GetTotalXpPort {

    int get(UUID userId);
}