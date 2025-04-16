package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.util.UUID;

public interface SaveDailyXpPort {

    void save(UUID userId, int xpAmount);
}
