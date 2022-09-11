package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.Sprint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraSprintDTO {
	private Long id;
	private String name;
	private String state;
	private Date startDate;
	private Date endDate;
	private Date completeDate;
	private Date activatedDate;

	public JiraSprintDTO(Long id) {
		this.id = id;
	}

	public Sprint toEntity() {
		return new Sprint(
			this.id,
			this.name,
			this.state,
			this.startDate,
			this.endDate,
			this.completeDate,
			this.activatedDate
		);
	}
}