package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.util.UUID;

public interface SaveTotalXpPort {

    void save(UUID userId, int xpAmount);
}