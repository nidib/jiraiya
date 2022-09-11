package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraEpicDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraEpicRepository;
import com.nidib.jiraiya.database.entities.Epic;
import com.nidib.jiraiya.database.services.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EpicUpdater {
	@Autowired
	private JiraEpicRepository jiraEpicRepository;
	@Autowired
	private EpicService epicService;

	public void update(String boardId) {
		List<Epic> epics = this.jiraEpicRepository.getEpics(boardId)
			.stream()
			.map(JiraEpicDTO::toEntity)
			.toList();

		this.epicService.saveManyEpics(epics);
		System.out.println("Epic: ✅");
	}
}