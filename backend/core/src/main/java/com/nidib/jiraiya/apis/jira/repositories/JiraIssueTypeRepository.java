package com.nidib.jiraiya.apis.jira.repositories;

import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraIssueTypeDTO;

import org.springframework.stereotype.Repository;

@Repository
public class JiraIssueTypeRepository {
	private final JiraEntityConverter<JiraIssueTypeDTO> jiraEntityConverter;

	public JiraIssueTypeRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraIssueTypeDTO.class);
	}

	public List<JiraIssueTypeDTO> getIssueTypes() {
		String endpoint = "/rest/api/2/issuetype";

		return jiraEntityConverter.getMany(endpoint);
	}
}