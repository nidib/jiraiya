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
@Table(name = "status", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class Status {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne()
	@JoinColumn(name = "status_category_id", referencedColumnName = "id")
	private StatusCategory statusCategory;

	public Status(Long id) {
		this.id = id;
	}
}