package com.nick.mockito;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.*;
import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(95,100,101,105);

		//list
		MatcherAssert.assertThat(scores, Matchers.hasSize(4));
		MatcherAssert.assertThat(scores, Matchers.hasItem(95));
		MatcherAssert.assertThat(scores, Matchers.hasItems(100,101));
		MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.greaterThan(90)));
		MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.lessThan(110)));
		
	}

}
