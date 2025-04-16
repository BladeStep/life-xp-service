package com.bladestepapp.lifexpxpserviceinfrastructure.entities;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("user_xp_total")
@Data
public class UserXpTotalEntry {

    @PrimaryKey
    private UUID userId;

    private int totalXp;

    public UserXpTotalEntry(UUID userId, int totalXp) {
        this.userId = userId;
        this.totalXp = totalXp;
    }
}
