package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.entities.IssueType;
import com.nidib.jiraiya.database.repositories.IssueTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueTypeService {
	@Autowired
	private IssueTypeRepository issueTypeRepository;

	public void saveManyIssueTypes(Iterable<IssueType> issueTypes) {
		issueTypeRepository.saveAll(issueTypes);
	}
}