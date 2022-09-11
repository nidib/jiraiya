package com.nidib.jiraiya;

import com.nidib.jiraiya.apps.updater.BasicInfoUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JiraiyaApplication {
	private final BasicInfoUpdater basicInfoUpdater;

	@Autowired
	JiraiyaApplication(BasicInfoUpdater basicInfoUpdater) {
		this.basicInfoUpdater = basicInfoUpdater;
	}

	public static void main(String[] args) {
		SpringApplication.run(JiraiyaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initialSeed() {
		String favoriteBoard = System.getenv("board");

		if (favoriteBoard != null) {
			basicInfoUpdater.update(favoriteBoard);
		}
	}
}