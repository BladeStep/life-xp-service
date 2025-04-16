CREATE TABLE IF NOT EXISTS xp_history (
                                          user_id UUID,
                                          activity_id UUID,
                                          created_at TIMESTAMP,
                                          xp_gained DOUBLE,
                                          PRIMARY KEY ((user_id, activity_id), created_at)
    ) WITH CLUSTERING ORDER BY (created_at DESC);

CREATE TABLE user_xp_daily (
                               userId UUID,
                               date DATE,
                               dailyXp INT,
                               PRIMARY KEY (userId, date)
) WITH CLUSTERING ORDER BY (date DESC);

CREATE TABLE user_xp_total (
                               userId UUID PRIMARY KEY,
                               totalXp INT
);