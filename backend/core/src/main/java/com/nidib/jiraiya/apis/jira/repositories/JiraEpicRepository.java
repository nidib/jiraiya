package com.nidib.jiraiya.apis.jira.repositories;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraEpicDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JiraEpicRepository {
	private final JiraEntityConverter<JiraEpicDTO> jiraEntityConverter;

	public JiraEpicRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraEpicDTO.class);
	}

	public List<JiraEpicDTO> getEpics(String boardId) {
		String endpoint = "/rest/agile/1.0/board/" + boardId + "/epic";

		return jiraEntityConverter.getManyPaginated(endpoint);
	}
}