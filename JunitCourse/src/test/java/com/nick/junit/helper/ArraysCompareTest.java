package com.nick.junit.helper;

import static org.junit.jupiter.api.Assertions.*;
import static java.time.Duration.*;

import java.util.Arrays;


import org.junit.jupiter.api.Test;

class ArraysCompareTest {

	@Test
	void testArraySort_RandomArray() {
		int [] numbers = { 12,3,1,5};
		int [] expected = { 1,3,5,12};
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@Test
	void testArraySort_NullArray() {
		int [] numbers = null;
		assertThrows(NullPointerException.class, () -> {
			Arrays.sort(numbers);
		});
	}

	@Test
	void testArraySort_Performance() {
		int [] numbers = { 12,3,1,5};
		
		assertTimeout(ofMillis(100), ()->{
			for(int i =0;i<1000000; ++i) {
				numbers[0] = i;
				Arrays.sort(numbers);
			}
		});
	}
	

}
