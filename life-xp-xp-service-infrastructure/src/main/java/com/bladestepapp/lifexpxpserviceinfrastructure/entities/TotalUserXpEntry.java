package com.bladestepapp.lifexpxpserviceinfrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@Table("total_user_xp")
public class TotalUserXpEntry {
    @PrimaryKey
    private final UUID userId;
    private long totalXp;
}
