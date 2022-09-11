package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.IssueType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraIssueTypeDTO {
	private Long id;
	private String description;
	private String name;

	public IssueType toEntity() {
		return new IssueType(
			this.id,
			this.description,
			this.name
		);
	}
}