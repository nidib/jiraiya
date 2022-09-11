package com.nidib.jiraiya.apis.jira.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JiraPaginatedValuesDTO<T> {
	private int maxResults;
	private int startAt;
	private boolean isLast;

	@JsonAlias({"issues"})
	private List<T> values;
}