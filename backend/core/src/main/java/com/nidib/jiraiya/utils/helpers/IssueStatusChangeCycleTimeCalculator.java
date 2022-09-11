package com.nidib.jiraiya.utils.helpers;

import com.nidib.jiraiya.database.entities.IssueStatusChange;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class IssueStatusChangeCycleTimeCalculator {
	private static Date getDate(int year, int month, int day, int hour, int minute) {
		return new Calendar.Builder()
			.setDate(year, month, day)
			.setTimeOfDay(hour, minute, 0)
			.build().getTime();
	}

	public static void insertCycleTimes(List<IssueStatusChange> issueStatusChanges) {
		for (int i = 1; i < issueStatusChanges.size(); i++) {
			int timeInStatus = DateDiffCalculator.timeDiff(
				issueStatusChanges.get(i - 1).getHappenedAt(),
				issueStatusChanges.get(i).getHappenedAt()
			);
			issueStatusChanges.get(0).setTimeInStatus(0L);
			issueStatusChanges.get(i).setTimeInStatus((long) timeInStatus);
		}
	}
}