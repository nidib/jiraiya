package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.Priority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}