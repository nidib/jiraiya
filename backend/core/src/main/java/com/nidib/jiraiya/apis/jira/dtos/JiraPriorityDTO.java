package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraPriorityDTO {
	private Long id;
	private String description;
	private String name;

	public Priority toEntity() {
		return new Priority(
			this.id,
			this.description,
			this.name
		);
	}
}