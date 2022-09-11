package com.nidib.jiraiya.apis.jira.repositories;

import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraSprintDTO;

import org.springframework.stereotype.Repository;

@Repository
public class JiraSprintRepository {
	private final JiraEntityConverter<JiraSprintDTO> jiraEntityConverter;

	public JiraSprintRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraSprintDTO.class);
	}

	public List<JiraSprintDTO> getAllSprints(String boardId) {
		String endpoint = "/rest/agile/1.0/board/"+boardId+"/sprint";

		return jiraEntityConverter.getManyPaginated(endpoint);
	}

	public JiraSprintDTO getSprintById(String sprintId) {
		String endpoint = "/rest/agile/1.0/sprint/"+sprintId;

		return jiraEntityConverter.getOne(endpoint);
	}
}