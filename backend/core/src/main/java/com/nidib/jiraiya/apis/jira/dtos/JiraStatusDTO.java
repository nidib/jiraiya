package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.Status;
import com.nidib.jiraiya.database.entities.StatusCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraStatusDTO {
	private Long id;
	private String name;
	private JiraStatusCategoryDTO statusCategory;

	public Status toEntity() {
		return new Status(
			this.id,
			this.name,
			new StatusCategory(this.statusCategory.getId())
		);
	}
}