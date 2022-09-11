package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraPriorityDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraPriorityRepository;
import com.nidib.jiraiya.database.entities.Priority;
import com.nidib.jiraiya.database.services.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriorityUpdater {
	@Autowired
	private JiraPriorityRepository jiraPriorityRepository;
	@Autowired
	private PriorityService priorityService;

	public void update() {
		List<Priority> priorities = this.jiraPriorityRepository.getAllPriorities()
			.stream()
			.map(JiraPriorityDTO::toEntity)
			.toList();

		this.priorityService.saveManyPriorities(priorities);
		System.out.println("Priority: ✅");
	}
}