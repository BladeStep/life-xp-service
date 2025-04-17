package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.util.UUID;

public interface GetTotalUserXpPort {

    long get(UUID userId);
}