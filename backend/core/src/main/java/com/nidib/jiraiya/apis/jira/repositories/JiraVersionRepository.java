package com.nidib.jiraiya.apis.jira.repositories;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraVersionDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JiraVersionRepository {
	private final JiraEntityConverter<JiraVersionDTO> jiraEntityConverter;

	public JiraVersionRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraVersionDTO.class);
	}

	public List<JiraVersionDTO> getAllVersions(String boardId) {
		String endpoint = "/rest/agile/1.0/board/" + boardId + "/version";

		return this.jiraEntityConverter.getManyPaginated(endpoint);
	}
}