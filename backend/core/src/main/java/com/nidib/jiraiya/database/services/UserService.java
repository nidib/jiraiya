package com.nidib.jiraiya.database.services;

import java.util.List;

import com.nidib.jiraiya.database.entities.User;
import com.nidib.jiraiya.database.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void saveManyUsers(Iterable<User> users) {
		this.userRepository.saveAll(users);
	}

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}
}