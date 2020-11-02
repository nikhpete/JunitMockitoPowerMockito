package com.nick.leapyear;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

@RunWith(JUnitParamsRunner.class)
public class DateUtilTest3 {

	@Test
	@Parameters ({
		"1992, true",
		"1996, true",
		"1991, false",
		"1900, false",
		"2000, true"
	})

	@TestCaseName("The year {0} should have leap year as {1}")
	public void isLeapYesr(int year, boolean shouldBeLeap) {
		assertThat(DateUtil.isLeapYear(year), is(shouldBeLeap));
	}


}
