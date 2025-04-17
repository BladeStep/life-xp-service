package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.util.UUID;

public interface SaveTotalUserXpPort {

    void save(UUID userId, long xpAmount);
}