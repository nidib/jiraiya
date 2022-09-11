package com.nidib.jiraiya.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "project", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class Project {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "key")
	private String key;

	@ManyToOne()
	@JoinColumn(name="lead_key", referencedColumnName = "key")
	private User lead;

	public Project(Long id) {
		this.id = id;
	}
}