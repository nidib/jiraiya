package com.nidib.jiraiya.database.entities;

import com.nidib.jiraiya.utils.constants.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "version", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class Version {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "archived")
	private boolean archived;

	@Column(name = "released")
	private boolean released;

	@ManyToOne()
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;
}