package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.IssueStatusChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusChangeRepository extends JpaRepository<IssueStatusChange, Long> {
}