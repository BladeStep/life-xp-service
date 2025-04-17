package com.bladestepapp.lifexpxpserviceinfrastructure.entities;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("xp_entries")
@Data
public class XpEntry {

    @PrimaryKey
    private XpEntryKey key;
    private long xp;

    public XpEntry(UUID userId, UUID activityId, long xp) {
        this.key = new XpEntryKey(userId, activityId, LocalDate.now());
        this.xp = xp;
    }
}
