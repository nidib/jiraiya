package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.repositories.VersionRepository;
import com.nidib.jiraiya.database.entities.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionService {
	@Autowired
	private VersionRepository versionRepository;

	public void saveManyVersions(Iterable<Version> versions) {
		this.versionRepository.saveAll(versions);
	}
}