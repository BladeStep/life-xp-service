package com.bladestepapp.lifexpxpserviceinfrastructure.entities;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Table("xp_entries")
@Data
public class XpEntry {

    @PrimaryKey
    private XpEntryKey key;
    private int xp;

    public XpEntry(UUID userId, UUID activityId, int xp) {
        this.key = new XpEntryKey(userId, activityId, Instant.now());
        this.xp = xp;
    }
}
