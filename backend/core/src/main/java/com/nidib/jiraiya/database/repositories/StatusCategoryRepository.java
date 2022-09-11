package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.StatusCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusCategoryRepository extends JpaRepository<StatusCategory, Long> {
}