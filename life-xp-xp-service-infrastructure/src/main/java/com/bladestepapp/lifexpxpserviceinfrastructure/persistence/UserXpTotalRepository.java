package com.bladestepapp.lifexpxpserviceinfrastructure.persistence;

import com.bladestepapp.lifexpxpserviceinfrastructure.entities.UserXpTotalEntry;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserXpTotalRepository extends CassandraRepository<UserXpTotalEntry, UUID>{
}