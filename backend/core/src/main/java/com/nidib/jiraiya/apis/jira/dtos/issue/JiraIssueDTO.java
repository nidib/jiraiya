package com.nidib.jiraiya.apis.jira.dtos.issue;

import com.nidib.jiraiya.apis.jira.dtos.issue.changelog.JiraIssueChangelogDTO;
import com.nidib.jiraiya.apis.jira.dtos.issue.fields.JiraIssueFieldsDTO;
import com.nidib.jiraiya.database.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraIssueDTO {
	private Long id;
	private String key;
	private JiraIssueFieldsDTO fields;
	private JiraIssueChangelogDTO changelog;

	public Issue toEntity() {
		User assignee = null;
		IssueType issueType = null;
		Priority priority = null;
		Sprint sprint = null;
		Status status = null;
		StatusCategory statusCategory = null;
		String summary = null;

		if (this.fields != null) {
			assignee = this.fields.getAssignee() != null ? new User(this.fields.getAssignee().getKey()) : null;
			issueType = this.fields.getIssueType() != null ? new IssueType(this.fields.getIssueType().getId()) : null;
			priority = this.fields.getPriority() != null ? new Priority(this.fields.getPriority().getId()) : null;
			sprint = this.fields.getSprint() != null ? new Sprint(this.fields.getSprint().getId()) : null;
			status = this.fields.getStatus() != null ? new Status(this.fields.getStatus().getId()) : null;
			statusCategory = this.fields.getStatus() != null ? new StatusCategory(this.fields.getStatus().getStatusCategory().getId()) : null;
			summary =  this.fields.getSummary();
		}

		return new Issue(this.id, this.key, summary, assignee,issueType, priority, sprint, status, statusCategory);
	}
}