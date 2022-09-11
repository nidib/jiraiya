package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraProjectDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraProjectRepository;
import com.nidib.jiraiya.database.entities.Project;
import com.nidib.jiraiya.database.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectUpdater {
	@Autowired
	private JiraProjectRepository jiraProjectRepository;
	@Autowired
	private ProjectService projectService;

	public void update(String boardId) {
		List<Project> projects = this.jiraProjectRepository.getProjectsByBoardId(boardId)
			.stream()
			.map(JiraProjectDTO::toEntity)
			.toList();

		this.projectService.saveManyProjects(projects);
		System.out.println("Project: ✅");
	}
}