CREATE KEYSPACE IF NOT EXISTS xp_keyspace
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE xp_keyspace;

CREATE TABLE IF NOT EXISTS xp_history (
                                          user_id UUID,
                                          activity_id UUID,
                                          created_at TIMESTAMP,
                                          xp_gained DOUBLE,
                                          PRIMARY KEY ((user_id, activity_id), created_at)
    ) WITH CLUSTERING ORDER BY (created_at DESC);

CREATE TABLE IF NOT EXISTS user_xp_daily (
                                             user_id UUID,
                                             date DATE,
                                             daily_xp INT,
                                             PRIMARY KEY (userId, date)
    ) WITH CLUSTERING ORDER BY (date DESC);

CREATE TABLE IF NOT EXISTS user_xp_total (
                                             user_id UUID PRIMARY KEY,
                                             total_xp INT
);