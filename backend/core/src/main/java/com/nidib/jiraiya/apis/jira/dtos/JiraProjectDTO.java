package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.Project;
import com.nidib.jiraiya.database.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraProjectDTO {
	private Long id;
	private String name;
	private String key;
	private JiraUserDTO lead;

	public Project toEntity() {
		return new Project(
			this.id,
			this.name,
			this.key,
			new User(this.lead.getKey())
		);
	}
}