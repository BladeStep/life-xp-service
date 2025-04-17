package com.bladestepapp.lifexpxpserviceinfrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("daily_user_xp")
@Data
@AllArgsConstructor
public class DailyUserXpEntry {

    @PrimaryKey
    private DailyUserXpEntryKey key;

    private long dailyXp;
}