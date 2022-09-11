package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicRepository extends JpaRepository<Epic, Long> {
}