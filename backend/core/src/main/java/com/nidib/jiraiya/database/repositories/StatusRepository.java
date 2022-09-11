package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}