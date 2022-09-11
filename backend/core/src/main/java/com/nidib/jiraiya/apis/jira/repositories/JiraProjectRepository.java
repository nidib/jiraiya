package com.nidib.jiraiya.apis.jira.repositories;

import java.util.ArrayList;
import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraProjectDTO;

import org.springframework.stereotype.Repository;

@Repository
public class JiraProjectRepository {
	private final JiraEntityConverter<JiraProjectDTO> jiraEntityConverter;

	public JiraProjectRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraProjectDTO.class);
	}

	private JiraProjectDTO getProjectByKey(String key) {
		String endpoint = "/rest/api/2/project/" + key;

		return jiraEntityConverter.getOne(endpoint);
	}

	public List<JiraProjectDTO> getProjectsByBoardId(String boardId) {
		String endpoint = "/rest/agile/1.0/board/" + boardId + "/project";
		List<JiraProjectDTO> projects = jiraEntityConverter.getMany(endpoint);
		List<JiraProjectDTO> detailedProjects = new ArrayList<>();

		for (JiraProjectDTO project : projects) {
			detailedProjects.add(this.getProjectByKey(project.getKey()));
		}

		return detailedProjects;
	}
}