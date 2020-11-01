package com.nick.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;

import java.util.*;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List arrayList = spy(ArrayList.class);
		
		assertEquals(0, arrayList.size());
		
		arrayList.add("Dummy");
		
		assertEquals(1, arrayList.size());
		
		arrayList.remove("Dummy");
		
		assertEquals(0, arrayList.size());
	}

}
