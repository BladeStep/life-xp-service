package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.util.UUID;

public interface GetDailyXpPort {

    int get(UUID userId);
}