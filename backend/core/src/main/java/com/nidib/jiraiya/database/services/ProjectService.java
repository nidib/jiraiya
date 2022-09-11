package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.repositories.ProjectRepository;
import com.nidib.jiraiya.database.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	public void saveManyProjects(Iterable<Project> projects) {
		projectRepository.saveAll(projects);
	}
}