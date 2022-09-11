package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.dtos.JiraSprintDTO;
import com.nidib.jiraiya.apis.jira.dtos.issue.JiraIssueDTO;
import com.nidib.jiraiya.apis.jira.dtos.issue.changelog.history.JiraChangelogHistoryDTO;
import com.nidib.jiraiya.apis.jira.repositories.JiraIssueRepository;
import com.nidib.jiraiya.database.entities.Issue;
import com.nidib.jiraiya.database.entities.IssueStatusChange;
import com.nidib.jiraiya.database.entities.Sprint;
import com.nidib.jiraiya.database.entities.User;
import com.nidib.jiraiya.database.services.IssueService;
import com.nidib.jiraiya.database.services.SprintService;
import com.nidib.jiraiya.database.services.StatusChangeService;
import com.nidib.jiraiya.database.services.UserService;
import com.nidib.jiraiya.utils.helpers.IssueStatusChangeCycleTimeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class IssueUpdater {
	private final JiraIssueRepository jiraIssueRepository;
	private final IssueService issueService;
	private final SprintService sprintService;
	private final UserService userService;
	private final StatusChangeService statusChangeService;
	
	@Autowired
	public IssueUpdater(JiraIssueRepository jiraIssueRepository, IssueService issueService, SprintService sprintService, UserService userService, StatusChangeService statusChangeService) {
		this.jiraIssueRepository = jiraIssueRepository;
		this.issueService = issueService;
		this.sprintService = sprintService;
		this.userService = userService;
		this.statusChangeService = statusChangeService;
	}

	public void update(String boardId) {
		List<Sprint> last10Sprints = sprintService.findAllSprintsOrderByDescWhereStateIsNot("future");
		List<JiraIssueDTO> allSprintIssues = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(last10Sprints.size());
		boolean timedOut;

		statusChangeService.removeALlStatusChanges();
		issueService.removeAllIssues();

		/* Iterates from old to new sprints */
		try {
			for (int i = last10Sprints.size() - 1; i >= 0; i--) {
				int finalI = i;
				executorService.execute(() -> {
					Sprint currentSprint = last10Sprints.get(finalI);
					List<JiraIssueDTO> sprintIssues = jiraIssueRepository.getIssuesBySprintId(boardId, currentSprint.getId());

					for (JiraIssueDTO sprintIssue : sprintIssues) {
						if (sprintIssue.getFields().getSprint() == null) {
							List<JiraSprintDTO> closedSprints = sprintIssue.getFields().getClosedSprints();

							closedSprints.sort(Comparator.comparing(JiraSprintDTO::getStartDate));
							sprintIssue.getFields().setSprint(new JiraSprintDTO(closedSprints.get(closedSprints.size() - 1).getId()));
						}
					}

					allSprintIssues.addAll(sprintIssues);
				});
			}
			executorService.shutdown();
			timedOut = executorService.awaitTermination(100L, TimeUnit.SECONDS);

			if (!timedOut) {
				throw new RuntimeException("timed out");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		/* Gets all users */
		List<User> allUsers = userService.getAllUsers();
		/* Removes users that are not on the team */
		List<Issue> issues = allSprintIssues
			.stream()
			.filter(jiraIssueDTO -> {
				if (jiraIssueDTO.getFields().getAssignee() == null) {
					return true;
				}

				return allUsers.stream().anyMatch(user -> user.getKey().equals(jiraIssueDTO.getFields().getAssignee().getKey()));
			})
			.map(JiraIssueDTO::toEntity)
			.toList();

		issueService.saveManyIssues(issues);
		System.out.println("Issue: ✅");

		issues = issueService.getAllIssues();
		ExecutorService executor = Executors.newFixedThreadPool(issues.size());

		try {
			for (Issue issue : issues) {
				executor.execute(() -> {
					List<JiraChangelogHistoryDTO> issueHistories = jiraIssueRepository.getIssueWithChangelogById(issue.getId()).getChangelog().getHistories();
					List<IssueStatusChange> issueStatusChanges = new ArrayList<>();

					for (JiraChangelogHistoryDTO issueHistory : issueHistories) {
						issueStatusChanges.addAll(issueHistory.getIssueStatusChangeEntities(issue.getId()));
					}

					IssueStatusChangeCycleTimeCalculator.insertCycleTimes(issueStatusChanges);

					statusChangeService.saveManyStatusChanges(issueStatusChanges);
				});
			}
			executor.shutdown();

			timedOut = executor.awaitTermination(120L, TimeUnit.SECONDS);

			if (!timedOut) {
				throw new RuntimeException("timed out");
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("IssueStatusChange: ✅");
	}
}