package com.nidib.jiraiya.database.services;

import java.util.List;

import com.nidib.jiraiya.database.entities.StatusCategory;
import com.nidib.jiraiya.database.repositories.StatusCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusCategoryService {
	@Autowired
	private StatusCategoryRepository statusCategoryRepository;

	public void saveManyStatusCategories(Iterable<StatusCategory> statusCategories) {
		statusCategoryRepository.saveAll(statusCategories);
	}

	public List<StatusCategory> getAll() {
		return statusCategoryRepository.findAll();
	}
}