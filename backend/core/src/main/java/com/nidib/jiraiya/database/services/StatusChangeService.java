package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.entities.IssueStatusChange;
import com.nidib.jiraiya.database.repositories.StatusChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusChangeService {
	@Autowired
	private StatusChangeRepository statusChangeRepository;

	public void saveManyStatusChanges(Iterable<IssueStatusChange> issueStatusChanges) {
		this.statusChangeRepository.saveAll(issueStatusChanges);
	}

	public void removeALlStatusChanges() {
		this.statusChangeRepository.deleteAll();
	}
}