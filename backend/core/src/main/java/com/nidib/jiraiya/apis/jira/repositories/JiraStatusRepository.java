package com.nidib.jiraiya.apis.jira.repositories;

import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraStatusDTO;

import org.springframework.stereotype.Repository;

@Repository
public class JiraStatusRepository {
	private final JiraEntityConverter<JiraStatusDTO> jiraEntityConverter;

	public JiraStatusRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraStatusDTO.class);
	}

	public List<JiraStatusDTO> getAllStatuses() {
		String endpoint = "/rest/api/2/status";

		return jiraEntityConverter.getMany(endpoint);
	}
}