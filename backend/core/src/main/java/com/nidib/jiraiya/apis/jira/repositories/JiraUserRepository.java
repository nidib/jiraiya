package com.nidib.jiraiya.apis.jira.repositories;

import java.util.ArrayList;
import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraProjectDTO;
import com.nidib.jiraiya.apis.jira.dtos.JiraUserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JiraUserRepository {
	private final JiraEntityConverter<JiraUserDTO> jiraEntityConverter;

	@Autowired
	private JiraProjectRepository jiraProjectRepository;

	public JiraUserRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraUserDTO.class);
	}

	public List<JiraUserDTO> getUsersByProjectKey(String projectKey) {
		String endpoint = "/rest/api/2/user/assignable/search?project="+projectKey;

		return jiraEntityConverter.getMany(endpoint);
	}

	public List<JiraUserDTO> getUsersByBoard(String boardId) {
		List<JiraProjectDTO> boardProjects = this.jiraProjectRepository.getProjectsByBoardId(boardId);
		List<JiraUserDTO> users = new ArrayList<>();

		for (JiraProjectDTO project : boardProjects) {
			List<JiraUserDTO> projectUsers = this.getUsersByProjectKey(project.getKey());

			users.addAll(projectUsers);
		}

		return users;
	}
}