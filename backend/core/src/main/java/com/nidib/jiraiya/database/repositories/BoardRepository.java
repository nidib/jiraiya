package com.nidib.jiraiya.database.repositories;

import com.nidib.jiraiya.database.entities.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}