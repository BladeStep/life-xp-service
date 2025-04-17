package com.bladestepapp.lifexpxpserviceinfrastructure.adapter;

import com.bladestepapp.lifexpxpservicecore.port.persistence.GetTotalUserXpPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.TotalUserXpEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.persistence.TotalUserXpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class TotalUserXpCassandraReadAdapter implements GetTotalUserXpPort {

    private final TotalUserXpRepository repository;

    @Override
    public long get(UUID userId) {
        return repository.findById(userId)
                .map(TotalUserXpEntry::getTotalXp)
                .orElse(0L);
    }
}