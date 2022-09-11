package com.nidib.jiraiya.apps.updater;

import com.nidib.jiraiya.apps.updater.updaters.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicInfoUpdater {
	private final BoardUpdater boardUpdater;
	private final SprintUpdater sprintUpdater;
	private final IssueTypeUpdater issueTypeUpdater;
	private final PriorityUpdater priorityUpdater;
	private final StatusCategoryUpdater statusCategoryUpdater;
	private final StatusUpdater statusUpdater;
	private final ProjectUpdater projectUpdater;
	private final UserUpdater userUpdater;
	private final VersionUpdater versionUpdater;
	private final EpicUpdater epicUpdater;
	private final IssueUpdater issueUpdater;

	@Autowired
	public BasicInfoUpdater(
		BoardUpdater boardUpdater,
		SprintUpdater sprintUpdater,
		IssueTypeUpdater issueTypeUpdater,
		PriorityUpdater priorityUpdater,
		StatusCategoryUpdater statusCategoryUpdater,
		StatusUpdater statusUpdater,
		ProjectUpdater projectUpdater,
		UserUpdater userUpdater,
		VersionUpdater versionUpdater,
		EpicUpdater epicUpdater,
		IssueUpdater issueUpdater
	) {
		this.boardUpdater = boardUpdater;
		this.sprintUpdater = sprintUpdater;
		this.issueTypeUpdater = issueTypeUpdater;
		this.priorityUpdater = priorityUpdater;
		this.statusCategoryUpdater = statusCategoryUpdater;
		this.statusUpdater = statusUpdater;
		this.projectUpdater = projectUpdater;
		this.userUpdater = userUpdater;
		this.versionUpdater = versionUpdater;
		this.epicUpdater = epicUpdater;
		this.issueUpdater = issueUpdater;
	};

	public void update(String boardId) {
		System.out.println("Starting updater for board " + boardId);

		this.issueTypeUpdater.update();
		this.priorityUpdater.update();
		this.statusCategoryUpdater.update();
		this.statusUpdater.update();
		this.boardUpdater.update(boardId);
		this.sprintUpdater.update(boardId);
		this.userUpdater.update(boardId);
		this.projectUpdater.update(boardId);
		this.versionUpdater.update(boardId);
		this.epicUpdater.update(boardId);
		this.issueUpdater.update(boardId);

		System.out.println("Updater finished for board " + boardId);
	}
}