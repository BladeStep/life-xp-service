package com.bladestepapp.lifexpxpserviceinfrastructure.repositories;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.XpEntry;
import com.bladestepapp.lifexpxpserviceinfrastructure.entities.XpEntryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface XpRepository extends CassandraRepository<XpEntry, XpEntryKey>{
}
