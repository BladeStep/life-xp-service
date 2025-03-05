package com.bladestepapp.lifexpxpserviceinfrastructure.entities;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.Instant;
import java.util.UUID;

@PrimaryKeyClass
@Data
public class XpEntryKey {

    @PrimaryKeyColumn(name = "user_id", type = PARTITIONED)
    private UUID userId;

    @PrimaryKeyColumn(name = "activity_id", type = PARTITIONED)
    private UUID activityId;

    @PrimaryKeyColumn(name = "created_at", ordinal = 2)
    private Instant createdAt;

    public XpEntryKey(UUID userId, UUID activityId, Instant createdAt) {
        this.userId = userId;
        this.activityId = activityId;
        this.createdAt = createdAt;
    }
}
