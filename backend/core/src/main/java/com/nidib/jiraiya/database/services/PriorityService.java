package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.repositories.PriorityRepository;
import com.nidib.jiraiya.database.entities.Priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriorityService {
	@Autowired
	private PriorityRepository priorityRepository;

	public void saveManyPriorities(Iterable<Priority> issueTypes) {
		priorityRepository.saveAll(issueTypes);
	}
}