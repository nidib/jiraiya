package com.nidib.jiraiya.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nidib.jiraiya.utils.constants.DatabaseConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issue_type", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class IssueType {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "name")
	private String name;

	public IssueType(Long id) {
		this.id = id;
	}
}