package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.IssueType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueTypeRepository extends JpaRepository<IssueType, Long> {
}