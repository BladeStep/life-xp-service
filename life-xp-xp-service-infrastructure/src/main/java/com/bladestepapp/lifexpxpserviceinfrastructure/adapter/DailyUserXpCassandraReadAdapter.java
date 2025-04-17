package com.bladestepapp.lifexpxpserviceinfrastructure.adapter;

import com.bladestepapp.lifexpxpservicecore.port.persistence.GetDailyUserXpPort;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.DailyUserXpEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.persistence.DailyUserXpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DailyUserXpCassandraReadAdapter implements GetDailyUserXpPort {

    private final DailyUserXpRepository repository;

    @Override
    public long getByUserIdAndDate(UUID userId, LocalDate date) {
        return repository.findByKey_UserIdAndKey_Date(userId, date)
                .map(DailyUserXpEntry::getDailyXp)
                .orElse(0L);
    }
}
