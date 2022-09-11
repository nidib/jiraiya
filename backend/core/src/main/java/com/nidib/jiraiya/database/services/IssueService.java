package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.entities.Issue;
import com.nidib.jiraiya.database.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
	@Autowired
	private IssueRepository issueRepository;

	public void saveManyIssues(Iterable<Issue> issues) {
		this.issueRepository.saveAll(issues);
	}

	public List<Issue> getAllIssues() {
		return this.issueRepository.findAll();
	}

	public void removeAllIssues() {
		this.issueRepository.deleteAll();
	}
}