package com.bladestepapp.lifexpxpserviceinfrastructure.persistence;

import com.bladestepapp.lifexpxpserviceinfrastructure.entities.UserXpDailyEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.UserXpDailyEntryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserXpDailyRepository extends CassandraRepository<UserXpDailyEntry, UserXpDailyEntryKey> {
}
