package com.nidib.jiraiya.database.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "sprint", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class Sprint {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "state")
	private String state;

	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "complete_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date completeDate;

	@Column(name = "activated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date activatedDate;

	public Sprint(Long id) {
		this.id = id;
	}
}