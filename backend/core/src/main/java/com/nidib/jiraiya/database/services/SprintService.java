package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.repositories.SprintRepository;
import com.nidib.jiraiya.database.entities.Sprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {
	@Autowired
	private SprintRepository sprintRepository;

	public void saveManySprints(Iterable<Sprint> sprints) {
		sprintRepository.saveAll(sprints);
	}

	public List<Sprint> findAllSprintsOrderByDescWhereStateIsNot(String status) {
		return this.sprintRepository.findTop10ByStateNotOrderByStartDateDesc(status);
	}
}