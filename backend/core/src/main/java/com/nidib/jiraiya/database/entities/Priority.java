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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "priority", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class Priority {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "name")
	private String name;

	public Priority(Long id) {
		this.id = id;
	}
}