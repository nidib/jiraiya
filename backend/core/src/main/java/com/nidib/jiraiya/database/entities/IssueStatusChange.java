package com.nidib.jiraiya.database.entities;

import com.nidib.jiraiya.utils.constants.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issue_status_change", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class IssueStatusChange {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "field")
	private String field;

	@Column(name = "\"from\"")
	private String from;

	@Column(name = "\"to\"")
	private String to;

	@Column(name = "happened_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date happenedAt;

	@Column(name = "time_in_status")
	private Long timeInStatus;

	@ManyToOne()
	@JoinColumn(name = "issue_id", referencedColumnName = "id")
	private Issue issue;

	public IssueStatusChange(Long id, String field, String from, String to, Date happenedAt) {
		this.id = id;
		this.field = field;
		this.from = from;
		this.to = to;
		this.happenedAt = happenedAt;
	}
}