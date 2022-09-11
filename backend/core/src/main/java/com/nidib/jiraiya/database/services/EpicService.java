package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.entities.Epic;
import com.nidib.jiraiya.database.repositories.EpicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpicService {
	@Autowired
	private EpicRepository epicRepository;

	public void saveManyEpics(Iterable<Epic> epics) {
		this.epicRepository.saveAll(epics);
	}
}