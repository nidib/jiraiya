package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.Epic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraEpicDTO {
	private Long id;
	private String key;
	private String name;
	private String summary;
	private boolean done;

	public Epic toEntity() {
		return new Epic(
			this.id,
			this.key,
			this.name,
			this.summary,
			this.done
		);
	}
}