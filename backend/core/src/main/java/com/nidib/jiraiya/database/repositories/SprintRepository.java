package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.Sprint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
	List<Sprint> findTop10ByStateNotOrderByStartDateDesc(String status);
}