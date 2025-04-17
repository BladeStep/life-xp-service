package com.bladestepapp.lifexpxpserviceinfrastructure.adapter;

import com.bladestepapp.lifexpxpservicecore.port.persistence.SaveDailyUserXpPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.persistence.DailyUserXpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DailyUserXpCassandraWriteAdapter implements SaveDailyUserXpPort {

    private final DailyUserXpRepository repository;

    @Override
    public void save(UUID userId, LocalDate date, long xpAmount) {
        if (!tryInsert(userId, date, xpAmount)) {
            repository.incrementDailyXp(userId, date, xpAmount);
        }
    }

    private boolean tryInsert(UUID userId, LocalDate date, long xpAmount) {
        return repository.insertIfNotExists(userId, date, xpAmount);
    }
}
