package com.nidib.jiraiya.database.entities;

import javax.persistence.*;

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
@Table(name = "status_category", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class StatusCategory {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "key")
	private String key;

	@Column(name = "name")
	private String name;

	public StatusCategory(Long id) {
		this.id = id;
	}
}