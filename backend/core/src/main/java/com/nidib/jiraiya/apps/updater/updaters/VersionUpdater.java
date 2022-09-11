package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraVersionDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraVersionRepository;
import com.nidib.jiraiya.database.entities.Version;
import com.nidib.jiraiya.database.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VersionUpdater {
	@Autowired
	private JiraVersionRepository jiraVersionRepository;
	@Autowired
	private VersionService versionService;

	public void update(String boardId) {
		List<Version> versions = this.jiraVersionRepository.getAllVersions(boardId)
			.stream()
			.map(JiraVersionDTO::toEntity)
			.toList();

		this.versionService.saveManyVersions(versions);
		System.out.println("Version: ✅");
	}
}