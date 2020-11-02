package com.nick.leapyear;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateUtilTest {
	
	@Test
	public void nomalYearIsLeap() {
		assertTrue(DateUtil.isLeapYear(1992));
	}
	
	@Test
	public void nomalYearIsLeapEg2() {
		assertTrue(DateUtil.isLeapYear(1996));
	}
	
	@Test
	public void nomalYearIsNotLeap() {
		assertFalse(DateUtil.isLeapYear(1991));
	}
	
	@Test
	public void centuaryYearNotLeapYear() {
		assertFalse(DateUtil.isLeapYear(1900));
	}
	
	@Test
	public void year2000Leap() {
		assertTrue(DateUtil.isLeapYear(2000));
	}
}
