package com.nidib.jiraiya.apis.jira.repositories;

import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.JiraStatusCategoryDTO;

import org.springframework.stereotype.Repository;

@Repository
public class JiraStatusCategoryRepository {
	private final JiraEntityConverter<JiraStatusCategoryDTO> jiraEntityConverter;

	public JiraStatusCategoryRepository(JiraApi jiraApi) {
		this.jiraEntityConverter = new JiraEntityConverter<>(jiraApi, JiraStatusCategoryDTO.class);
	}

	public List<JiraStatusCategoryDTO> getAllStatusCategories() {
		String endpoint = "/rest/api/2/statuscategory";

		return jiraEntityConverter.getMany(endpoint);
	}
}