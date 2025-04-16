package com.bladestepapp.lifexpxpserviceinfrastructure.entities;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user_xp_daily")
@Data
public class UserXpDailyEntry {

    @PrimaryKey
    private UserXpDailyEntryKey key;

    private int dailyXp;
}