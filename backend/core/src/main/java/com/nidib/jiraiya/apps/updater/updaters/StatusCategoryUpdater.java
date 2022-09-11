package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraStatusCategoryDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraStatusCategoryRepository;
import com.nidib.jiraiya.database.entities.StatusCategory;
import com.nidib.jiraiya.database.services.StatusCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusCategoryUpdater {
	@Autowired
	private JiraStatusCategoryRepository jiraStatusCategoryRepository;
	@Autowired
	private StatusCategoryService statusCategoryService;

	public void update() {
		List<StatusCategory> statusCategories = this.jiraStatusCategoryRepository.getAllStatusCategories()
			.stream()
			.map(JiraStatusCategoryDTO::toEntity)
			.toList();

		this.statusCategoryService.saveManyStatusCategories(statusCategories);
		System.out.println("StatusCategory: ✅");
	}
}