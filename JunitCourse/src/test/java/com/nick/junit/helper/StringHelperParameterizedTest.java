package com.nick.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class StringHelperParameterizedTest {

	public static Collection<Object[]> testConditions() {
		return Arrays.asList(new Object[][] {
				{"AACD", "CD"},{"ACD", "CD"},
		});
	}
	
	@ParameterizedTest(name = "The expected output of {1} is obtained with input {0}")
	@MethodSource("testConditions")
	void testTruncateAInFirst2Positions(String input, String expectedOutput) {
		StringHelper helper = new StringHelper();
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}

}
