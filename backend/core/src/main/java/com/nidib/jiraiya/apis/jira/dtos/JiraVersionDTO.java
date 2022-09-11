package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.Project;
import com.nidib.jiraiya.database.entities.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JiraVersionDTO {
	private Long id;
	private String name;
	private String description;
	private boolean archived;
	private boolean released;
	private Long projectId;

	public Version toEntity() {
		return new Version(
			this.id,
			this.name,
			this.description,
			this.archived,
			this.released,
			new Project(this.projectId)
		);
	}
}