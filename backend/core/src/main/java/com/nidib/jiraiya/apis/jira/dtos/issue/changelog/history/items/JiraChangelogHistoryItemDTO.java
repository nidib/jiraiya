package com.nidib.jiraiya.apis.jira.dtos.issue.changelog.history.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraChangelogHistoryItemDTO {
	private Long id;
	private String field;
	private String from;
	private String to;
}