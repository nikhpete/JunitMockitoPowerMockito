package com.nick.junit.helper;

import org.junit.jupiter.api.*;

class QuickBeforeAfterTest {
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Before Class executed");
	}
	
	@BeforeEach
	public void setUp() {
		System.out.println("Before executed");
	}

	@Test
	void test1() {
		System.out.println("Test 1 executed");
	}
	
	@Test
	void test2() {
		System.out.println("Test 2 executed");
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("After Executed");
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("After class Executed");
	}

}
