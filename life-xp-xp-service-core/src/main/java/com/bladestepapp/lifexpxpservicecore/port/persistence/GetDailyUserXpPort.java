package com.bladestepapp.lifexpxpservicecore.port.persistence;

import java.time.LocalDate;
import java.util.UUID;

public interface GetDailyUserXpPort {

    long getByUserIdAndDate(UUID userId, LocalDate date);

    default long getForToday(UUID userId) {
        return getByUserIdAndDate(userId, LocalDate.now());
    }
}