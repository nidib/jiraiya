package com.nidib.jiraiya.apis.jira.repositories;

import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraPriorityDTO;

import org.springframework.stereotype.Repository;

@Repository
public class JiraPriorityRepository {
	private final JiraEntityConverter<JiraPriorityDTO> jiraEntityConverter;

	public JiraPriorityRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraPriorityDTO.class);
	}

	public List<JiraPriorityDTO> getAllPriorities() {
		String endpoint = "/rest/api/2/priority";

		return jiraEntityConverter.getMany(endpoint);
	}
}