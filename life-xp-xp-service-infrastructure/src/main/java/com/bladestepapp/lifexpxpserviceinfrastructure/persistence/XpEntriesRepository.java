package com.bladestepapp.lifexpxpserviceinfrastructure.persistence;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.XpEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.XpEntryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface XpEntriesRepository extends CassandraRepository<XpEntry, XpEntryKey>{
}
