package com.nidib.jiraiya.utils.helpers;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateDiffCalculator {
	private static final String TIMEZONE = "America/Sao_Paulo";
	private static final int WORK_FROM = 8;
	private static final int WORK_UNTIL = 18;
	private static final int precision = 15;
	private static final List<DayOfWeek> WEEKEND = new ArrayList<>(List.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));

	private static boolean isWithinWorkTime(LocalDateTime localDateTime) {
		return localDateTime.getHour() >= WORK_FROM && localDateTime.getHour() < WORK_UNTIL;
	}

	private static boolean isWeekend(LocalDateTime localDateTime) {
		return WEEKEND.stream().toList().contains(localDateTime.getDayOfWeek());
	}

	public static int timeDiff(Date d1, Date d2) {
		LocalDateTime local1 = d1.toInstant().atZone(ZoneId.of(TIMEZONE)).toLocalDateTime();
		LocalDateTime local2 = d2.toInstant().atZone(ZoneId.of(TIMEZONE)).toLocalDateTime();
		boolean startedOrFinishedOnAWeekend = isWeekend(local1) || isWeekend(local2);
		int minutesWorked = 0;

		if (local1.isAfter(local2)) {
			return 0;
		}

		while (local1.isBefore(local2)) {
			if (isWithinWorkTime(local1) && (startedOrFinishedOnAWeekend || !isWeekend(local1))) {
				minutesWorked += precision;
			}

			local1 = local1.plusMinutes(precision);
		}

		return minutesWorked;
	}
}