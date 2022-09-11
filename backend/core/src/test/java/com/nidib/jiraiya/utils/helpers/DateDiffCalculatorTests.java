package com.nidib.jiraiya.utils.helpers;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateDiffCalculatorTests {
	private static Date getDate(int year, int month, int day, int hour, int minute) {
		return new Calendar.Builder()
			.setDate(year, month, day)
			.setTimeOfDay(hour, minute, 0)
			.build().getTime();
	}

	@Test
	void itShouldReturnTheAmountOfWorkMinutesBetweenTwoDatesOverWeek() {
		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 14, 9, 0),
			getDate(2022, Calendar.APRIL, 14, 11, 0)
		), 120);

		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 13, 9, 0),
			getDate(2022, Calendar.APRIL, 14, 8, 30)
		), 570);

		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.MARCH, 30, 9, 0),
			getDate(2022, Calendar.APRIL, 1, 15, 30)
		), 1590);
	}

	@Test
	void itShouldReturnTheAmountOfWorkMinutesBetweenTwoDatesOverWeekend() {
		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 15, 9, 0),
			getDate(2022, Calendar.APRIL, 18, 11, 0)
		), 720);
	}

	@Test
	void itShouldReturnTheAmountOfWorkMinutesBetweenTwoDatesAndConsiderWeekendIfOneOfTwoDatesIsOnAWeekend() {
		/*
		 * Started on a SATURDAY and finished on a weekday
		 */
		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 16, 9, 0),
			getDate(2022, Calendar.APRIL, 18, 11, 0)
		), 22 * 60);

		/*
		 * Started on a SATURDAY and finished on a SUNDAY
		 */
		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 16, 9, 0),
			getDate(2022, Calendar.APRIL, 17, 11, 0)
		), 12 * 60);

		/*
		 * Started on a weekday and finished on a SATURDAY
		 */
		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 15, 9, 0),
			getDate(2022, Calendar.APRIL, 16, 11, 0)
		), 12 * 60);
	}

	@Test
	void itShouldReturnZeroIfFirstDateIsAfterTheSecond() {
		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 18, 12, 0),
			getDate(2022, Calendar.APRIL, 18, 11, 0)
		), 0);

		assertEquals(DateDiffCalculator.timeDiff(
			getDate(2022, Calendar.APRIL, 19, 9, 0),
			getDate(2022, Calendar.APRIL, 18, 11, 0)
		), 0);
	}
}