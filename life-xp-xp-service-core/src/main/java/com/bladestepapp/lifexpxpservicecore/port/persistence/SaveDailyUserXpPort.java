package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.time.LocalDate;
import java.util.UUID;

public interface SaveDailyUserXpPort {

    void save(UUID userId, LocalDate date, long xpAmount);

    default void saveForToday(UUID userId, long xpAmount) {
        save(userId, LocalDate.now(), xpAmount);
    }
}
