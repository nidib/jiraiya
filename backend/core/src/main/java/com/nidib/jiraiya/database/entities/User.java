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
@Table(name = "user", schema = DatabaseConstants.JIRAIYA_SCHEMA)
public class User {
	@Id
	@Column(name = "key")
	private String key;

	@Column(name = "name")
	private String name;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "email_address")
	private String emailAddress;

	public User(String key) {
		this.key = key;
	}
}