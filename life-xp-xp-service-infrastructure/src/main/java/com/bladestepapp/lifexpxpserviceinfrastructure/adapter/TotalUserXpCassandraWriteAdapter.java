package com.bladestepapp.lifexpxpserviceinfrastructure.adapter;

import com.bladestepapp.lifexpxpservicecore.port.persistence.SaveTotalUserXpPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.persistence.TotalUserXpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class TotalUserXpCassandraWriteAdapter implements SaveTotalUserXpPort {

    private final TotalUserXpRepository repository;

    @Override
    public void save(UUID userId, long xpAmount) {
        if (!tryInsert(userId, xpAmount)) {
            repository.incrementTotalXp(userId, xpAmount);
        }
    }

    private boolean tryInsert(UUID userId, long xpAmount) {
        return repository.insertIfNotExists(userId, xpAmount);
    }
}