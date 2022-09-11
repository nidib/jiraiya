package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraUserDTO {
	private String key;
	private String name;
	private String displayName;
	private String emailAddress;

	public User toEntity() {
		return new User(
			this.key,
			this.name,
			this.displayName,
			this.emailAddress
		);
	}
}