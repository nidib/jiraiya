package com.nidib.jiraiya.apis.jira.dtos;

import com.nidib.jiraiya.database.entities.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraBoardDTO {
	private Long id;
	private String name;
	private String type;

	public Board toEntity() {
		return new Board(
			this.id,
			this.name,
			this.type
		);
	}
}