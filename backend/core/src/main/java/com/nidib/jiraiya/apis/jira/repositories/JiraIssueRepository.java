package com.nidib.jiraiya.apis.jira.repositories;

import java.util.List;

import com.nidib.jiraiya.apis.jira.JiraApi;
import com.nidib.jiraiya.apis.jira.JiraEntityConverter;
import com.nidib.jiraiya.apis.jira.dtos.issue.JiraIssueDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JiraIssueRepository {
	private final JiraEntityConverter<JiraIssueDTO> jiraIssueDTOConverter;

	public JiraIssueRepository(JiraApi jiraApi) {
		this.jiraIssueDTOConverter = new JiraEntityConverter<>(jiraApi, JiraIssueDTO.class);
	}

	public JiraIssueDTO getIssueWithInfoBySprintId(String issueId) {
		String endpoint = "/rest/api/2/search?jql=issue="+issueId+"&maxResults=1&expand=xpto&fields=summary,assignee,creator,reporter,issuetype,priority,status,project,resolution,created";

		return jiraIssueDTOConverter.getManyPaginated(endpoint).get(0);
	}

	public List<JiraIssueDTO> getIssuesBySprintId(String sprintId) {
		String endpoint = "/rest/api/2/search?jql=project=AN+AND+sprint="+sprintId+"+ORDER+BY+created&maxResults=200&expand=xpto&fields=xpto";

		return jiraIssueDTOConverter.getManyPaginated(endpoint);
	}

	public JiraIssueDTO getIssueWithChangelogById(Long issueId) {
		String endpoint = "/rest/api/2/issue/"+issueId+"?expand=changelog&fields=timespent";
		
		return jiraIssueDTOConverter.getOne(endpoint);
	}

	public List<JiraIssueDTO> getIssuesBySprintId(String boardId, Long sprintId) {
		String endpoint = "/rest/agile/1.0/board/"+boardId+"/sprint/"+sprintId+"/issue?expand=xpto&fields=summary,assignee,sprint,closedSprints,creator,reporter,epic,issuetype,priority,status,project,resolution,created,resolutionDate";

		return jiraIssueDTOConverter.getManyPaginated(endpoint);
	}
}