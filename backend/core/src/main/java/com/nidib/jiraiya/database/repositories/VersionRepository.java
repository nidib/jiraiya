package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {
}