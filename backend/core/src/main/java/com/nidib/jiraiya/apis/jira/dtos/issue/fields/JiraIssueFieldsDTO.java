package com.nidib.jiraiya.apis.jira.dtos.issue.fields;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nidib.jiraiya.apis.jira.dtos.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraIssueFieldsDTO {
	private JiraUserDTO assignee;
	private List<JiraSprintDTO> closedSprints;
	private JiraSprintDTO sprint;
	private JiraProjectDTO project;
	private JiraPriorityDTO priority;
	private JiraStatusDTO status;
	private String summary;


	@JsonAlias({ "issuetype" })
	private JiraIssueTypeDTO issueType;
}