package com.nidib.jiraiya.database.entities;

import com.nidib.jiraiya.utils.constants.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issue", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class Issue {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "key")
	private String key;

	@Column(name = "summary")
	private String summary;

	@ManyToOne()
	@JoinColumn(name = "user_key", referencedColumnName = "key")
	private User user;

	@ManyToOne()
	@JoinColumn(name = "issue_type_id", referencedColumnName = "id")
	private IssueType issueType;

	@ManyToOne()
	@JoinColumn(name = "priority_id", referencedColumnName = "id")
	private Priority priority;

	@ManyToOne()
	@JoinColumn(name = "sprint_id", referencedColumnName = "id")
	private Sprint sprint;

	@ManyToOne()
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	private Status status;

	@ManyToOne()
	@JoinColumn(name = "status_category_id", referencedColumnName = "id")
	private StatusCategory statusCategory;

	public Issue(Long id) {
		this.id = id;
	}
}