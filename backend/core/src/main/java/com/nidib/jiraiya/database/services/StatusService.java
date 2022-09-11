package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.entities.Status;
import com.nidib.jiraiya.database.repositories.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;

	public void saveManyStatuses(Iterable<Status> statuses) {
		this.statusRepository.saveAll(statuses);
	}
}