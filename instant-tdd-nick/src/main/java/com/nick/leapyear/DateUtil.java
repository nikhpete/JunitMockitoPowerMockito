package com.nick.leapyear;

public class DateUtil {
	/**
	 * is Leap year
	 * @param year
	 * @return true if leap year
	 */
	public static boolean isLeapYear(int year) {
		return isDivisible(year,4) && 
				!isDivisible(year, 100) || 
				isDivisible(year, 400);
	}
	
	public static boolean isDivisible(int year, int divisor) {
		return year % divisor == 0;
	}
}
