package com.nick.mockito;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class ListTest {

	@Test
	public void testListSize() {
		List list = mock(List.class);
		when(list.size()).thenReturn(2);
		assertEquals(2, list.size());
	}
	
	@Test
	public void testListSize_ReturnMultipleValue() {
		List list = mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, list.size());
		assertEquals(3, list.size());
	}
	
	@Test
	public void testListGet() {
		List list = mock(List.class);
		when(list.get(anyInt())).thenReturn("something");
		assertEquals("something", list.get(0));
		assertEquals("something", list.get(1));
	}
	
	@Test
	public void testListGet_usingBDD() {
		List list = mock(List.class);
		given(list.get(anyInt())).willReturn("something");
		MatcherAssert.assertThat("something", CoreMatchers.is(list.get(0)));
		MatcherAssert.assertThat("something", CoreMatchers.is(list.get(1)));
	}

}
