package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraSprintDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraSprintRepository;
import com.nidib.jiraiya.database.entities.Sprint;
import com.nidib.jiraiya.database.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SprintUpdater {
	@Autowired
	private JiraSprintRepository jiraSprintRepository;
	@Autowired
	private SprintService sprintService;

	public void update(String boardId) {
		List<Sprint> activeSprints = this.jiraSprintRepository.getAllSprints(boardId)
			.stream()
			.map(JiraSprintDTO::toEntity)
			.toList();

		this.sprintService.saveManySprints(activeSprints);
		System.out.println("Sprint: ✅");
	}
}