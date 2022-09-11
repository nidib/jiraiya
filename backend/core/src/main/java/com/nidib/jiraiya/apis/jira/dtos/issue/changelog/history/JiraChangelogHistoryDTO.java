package com.nidib.jiraiya.apis.jira.dtos.issue.changelog.history;

import com.nidib.jiraiya.apis.jira.dtos.issue.changelog.history.items.JiraChangelogHistoryItemDTO;
import com.nidib.jiraiya.database.entities.Issue;
import com.nidib.jiraiya.database.entities.IssueStatusChange;
import com.nidib.jiraiya.utils.helpers.IssueStatusChangeCycleTimeCalculator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraChangelogHistoryDTO {
	private Long id;
	private Date created;
	private List<JiraChangelogHistoryItemDTO> items;

	public List<JiraChangelogHistoryItemDTO> getStatusChanges() {
		return this.items.stream().filter(item -> item.getField().equals("status")).toList();
	}

	public List<IssueStatusChange> getIssueStatusChangeEntities(Long issueId) {
		List<IssueStatusChange> issueStatusChanges = new ArrayList<>();
		List<JiraChangelogHistoryItemDTO> statusChanges = this.getStatusChanges();

		for (JiraChangelogHistoryItemDTO statusChange : statusChanges) {
			issueStatusChanges.add(
				new IssueStatusChange(
					this.id, statusChange.getField(),
					statusChange.getFrom(), statusChange.getTo(),
					this.created, null, new Issue(issueId)
				)
			);
		}
		IssueStatusChangeCycleTimeCalculator.insertCycleTimes(issueStatusChanges);

		return issueStatusChanges;
	}
}