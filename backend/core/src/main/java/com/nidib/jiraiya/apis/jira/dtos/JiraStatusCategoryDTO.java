package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.StatusCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraStatusCategoryDTO {
	private Long id;
	private String key;
	private String name;

	public StatusCategory toEntity() {
		return new StatusCategory(
			this.id,
			this.key,
			this.name
		);
	}
}