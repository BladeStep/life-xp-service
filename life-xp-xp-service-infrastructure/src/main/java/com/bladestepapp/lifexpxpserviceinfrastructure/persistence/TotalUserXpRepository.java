package com.bladestepapp.lifexpxpserviceinfrastructure.persistence;

import com.bladestepapp.lifexpxpserviceinfrastructure.entities.TotalUserXpEntry;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TotalUserXpRepository extends CassandraRepository<TotalUserXpEntry, UUID>{

    @Query("UPDATE total_user_xp SET total_xp = total_xp + ?1 WHERE user_id = ?0")
    void incrementTotalXp(UUID userId, long xp);

    @Query("INSERT INTO total_user_xp (user_id, total_xp) VALUES (?0, ?1) IF NOT EXISTS")
    boolean insertIfNotExists(UUID userId, long totalXp);
}