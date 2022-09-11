package com.nidib.jiraiya.apis.jira.repositories;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraBoardDTO;

import org.springframework.stereotype.Repository;

@Repository
public class JiraBoardRepository {
	private final JiraEntityConverter<JiraBoardDTO> jiraEntityConverter;

	public JiraBoardRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraBoardDTO.class);
	}

	public JiraBoardDTO getBoardById(String boardId) {
		String endpoint = "/rest/agile/1.0/board/" + boardId;

		return jiraEntityConverter.getOne(endpoint);
	}
}