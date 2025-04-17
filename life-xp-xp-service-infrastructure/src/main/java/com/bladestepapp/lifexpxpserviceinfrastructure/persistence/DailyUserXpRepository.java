package com.bladestepapp.lifexpxpserviceinfrastructure.persistence;

import com.bladestepapp.lifexpxpserviceinfrastructure.entities.DailyUserXpEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.DailyUserXpEntryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DailyUserXpRepository extends CassandraRepository<DailyUserXpEntry, DailyUserXpEntryKey> {

    Optional<DailyUserXpEntry> findByKey_UserIdAndKey_Date(UUID userId, LocalDate date);

    @Query("UPDATE daily_user_xp SET daily_xp = daily_xp + ?2 WHERE user_id = ?0 AND date = ?1")
    void incrementDailyXp(UUID userId, LocalDate date, long xp);

    @Query("INSERT INTO daily_user_xp (user_id, date, xp) VALUES (?, ?, ?) IF NOT EXISTS")
    boolean insertIfNotExists(UUID userId, LocalDate date, long xp);
}