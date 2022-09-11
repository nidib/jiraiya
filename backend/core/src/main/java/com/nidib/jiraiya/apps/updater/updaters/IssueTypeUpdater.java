package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraIssueTypeDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraIssueTypeRepository;
import com.nidib.jiraiya.database.entities.IssueType;
import com.nidib.jiraiya.database.services.IssueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IssueTypeUpdater {
	@Autowired
	private JiraIssueTypeRepository jiraIssueTypeRepository;
	@Autowired
	private IssueTypeService issueTypeService;

	public void update() {
		List<IssueType> issueTypes = this.jiraIssueTypeRepository.getIssueTypes()
			.stream()
			.map(JiraIssueTypeDTO::toEntity)
			.toList();

		this.issueTypeService.saveManyIssueTypes(issueTypes);
		System.out.println("IssueType: ✅");
	}
}