package com.nidib.jiraiya.apis.jira.dtos.issue.changelog;

import com.nidib.jiraiya.apis.jira.dtos.issue.changelog.history.JiraChangelogHistoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraIssueChangelogDTO {
	private int total;
	private List<JiraChangelogHistoryDTO> histories;
}