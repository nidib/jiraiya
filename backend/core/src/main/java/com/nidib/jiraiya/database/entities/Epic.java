package com.nidib.jiraiya.database.entities;

import com.nidib.jiraiya.utils.constants.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "epic", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class Epic {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "key")
	private String key;

	@Column(name = "name")
	private String name;

	@Column(name = "summary")
	private String summary;

	@Column(name = "done")
	private boolean done;
}