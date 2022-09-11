package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraUserDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraUserRepository;
import com.nidib.jiraiya.database.entities.User;
import com.nidib.jiraiya.database.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUpdater {
	@Autowired
	private JiraUserRepository jiraUserRepository;
	@Autowired
	private UserService userService;

	public void update(String boardId) {
		List<User> users = this.jiraUserRepository.getUsersByBoard(boardId)
			.stream()
			.map(JiraUserDTO::toEntity)
			.toList();

		this.userService.saveManyUsers(users);
		System.out.println("User: ✅");
	}
}