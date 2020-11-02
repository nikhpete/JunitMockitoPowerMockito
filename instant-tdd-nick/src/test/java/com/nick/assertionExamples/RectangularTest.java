package com.nick.assertionExamples;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RectangularTest {

	@Test
	public void tryAssertTrue() {
		Rectangle r = new Rectangle(10, 10);
		assertTrue(r.isSquare());
	}
	
	@Test
	public void tryAssertFalse() {
		Rectangle r = new Rectangle(9, 10);
		assertFalse(r.isSquare());
	}
	
	@Test
	public void tryAssertTrue2() {
		Rectangle r = new Rectangle(10, 10);
		assertTrue("Recatangle with same width and height should be square",r.isSquare());
	}
	
	@Test
	public void tryAssertNull() {
		Object o = null;
		assertNull(o);
	}
	
	@Test
	public void tryAssertNotNull() {
		Object o = new Rectangle(1,2);
		assertNotNull(o);
	}
	
	@Test
	public void tryAssertEquals() {
		assertEquals(16, new Rectangle(2, 8).getArea());
	}
	
	@Test
	public void tryAssertEqualsWithString() {
		assertEquals("Hello\nworld\nnow", "Hello\nworld\nnow");
	}
	
	@Test
	public void tryAssertNotEquals() {
		assertNotEquals(999, new Rectangle(2, 8).getArea());
	}
	
	@Test
	public void tryAssertEqualsWithDouble() {
		double actual = new Rectangle(1, 3).aspectRatio();
		double expected = 0.3333333;
		
		assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void tryAssertEqualsforObject() {
		assertEquals(new Rectangle(1, 1), new Rectangle(1, 1));
	}
	
	@Test
	public void tryAssertSame() {
		Rectangle obj1 = new Rectangle(2, 8);
		Rectangle obj2 = obj1;
		assertSame(obj1, obj2);
		
		Rectangle dupliOfObj1 = new Rectangle(2, 8);
		assertNotSame(obj1, dupliOfObj1);
		assertEquals(obj1, dupliOfObj1);
	}
	
	@Test
	@Ignore("WILL FAIL!!!")
	public void tryAssertFail() {
		Assert.fail("This was never meant to happen");
	}
	
	@Test
	public void tryAssertArray() {
		assertArrayEquals(new int[] {2,8}, new Rectangle(2, 8).getSides());
	}
	
	@Test
	public void tryAssertList() {
		assertEquals(Arrays.asList(2,8), new Rectangle(2, 8).getSideList());
	}
	
	@Test(timeout = 100L)
	@Ignore
	public void tryAssertTimeOut() {
		assertEquals(42, longRunMethod());
	}

	private int longRunMethod() {
		while(true) {}
	}
	
	@Test
	public void tryAssertThat() {
		org.hamcrest.MatcherAssert.assertThat("Sides should be equal for rectangle", new Rectangle(4, 4).isSquare(), is(true));
	}
	
	@Test
	public void tryAssertNotThat() {
		org.hamcrest.MatcherAssert.assertThat("Sides should be equal for rectangle", new Rectangle(3, 4).isSquare(), not(true));
	}
}
