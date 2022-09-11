package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraStatusDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraStatusRepository;
import com.nidib.jiraiya.database.entities.Status;
import com.nidib.jiraiya.database.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusUpdater {
	@Autowired
	private JiraStatusRepository jiraStatusRepository;
	@Autowired
	private StatusService statusService;

	public void update() {
		List<Status> statuses = this.jiraStatusRepository.getAllStatuses()
			.stream()
			.map(JiraStatusDTO::toEntity)
			.toList();

		this.statusService.saveManyStatuses(statuses);
		System.out.println("Status: ✅");
	}
}