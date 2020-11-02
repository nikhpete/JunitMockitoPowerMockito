package com.nick.mockitoRetrunValues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MockitoExampleTest {

	@Mock
	private SomeInterface someInterface;

	@Captor
	private ArgumentCaptor<List<String>> listCapture;

	@Test
	public void testExample1() {
		when(someInterface.getMatchingSize(anyInt(), anyInt())).thenReturn(1);

		for(int i=0;i<5 ;++i) {
			System.out.println(someInterface.getMatchingSize(1, 2));
		}
		System.out.println();
	}

	@Test
	public void testExample2() {
		when(someInterface.getMatchingSize(eq(1), eq(2))).thenReturn(1);

		for(int i=0;i<5 ;++i) {
			System.out.println(someInterface.getMatchingSize(1, 2));
		}
		System.out.println();
	}

	@Test
	public void testExample3() {
		when(someInterface.getMatchingSize(eq(1), eq(2))).thenReturn(1).thenReturn(2).thenReturn(3);

		for(int i=0;i<5 ;++i) {
			System.out.println(someInterface.getMatchingSize(1, 2));
		}
		System.out.println();

		verify(someInterface, times(5)).getMatchingSize(1, 2);
	}

	@Test
	@Ignore
	public void testExample4() {
		when(someInterface.getMatchingSize(9, 5)).thenReturn(1);

		for(int i=0;i<5 ;++i) {
			System.out.println(someInterface.getMatchingSize(1, 2));
		}
		System.out.println();
	}

	@Test
	public void testExample5() {
		when(someInterface.getMatchingSize(eq(1), eq(2))).thenReturn(1).thenReturn(2).thenReturn(3);
		new Thread(() -> {
			for(int i=0;i<5 ;++i) {
				System.out.println(someInterface.getMatchingSize(1, 2));
				try {
					Thread.sleep(10);
				} catch(InterruptedException e) {}
			}
		}).start();
		System.out.println();

		verify(someInterface, timeout(2000).atLeast(3)).getMatchingSize(1, 2);
	}

	@Test
	public void verifyArgument() {
		someInterface.reciveList(Arrays.asList("A","B","C"));

		//verify(someInterface).reciveList(listCapture.capture());

		//assertEquals(3, listCapture.getValue().size());

		verify(someInterface).reciveList(argThat(list -> list.size() == 3));

	}

	@Test(expected = IOException.class)
	public void willThrow() throws Exception {
		when(someInterface.isFileValid(anyString())).thenThrow(new IOException());

		someInterface.isFileValid("myFile");
	}

	@Test
	public void theAnswer() {

		when(someInterface.getMatchingSize(anyInt(), anyInt())).thenAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				return (int)invocation.getArgument(0) + (int)invocation.getArgument(1);
			}
		});

		assertEquals(4, someInterface.getMatchingSize(1, 3));
	}

	@Test
	public void spying() {
		Set<Integer> set = spy(new LinkedHashSet<>());

		calculateprime(set,100);

		assertTrue(set.contains(31));
		
		verify(set).add(31);
	}

	private void calculateprime(Set<Integer> primes, int max) {
		for(int i=2; i<=max;++i) {
			if(!divisibleByAny(i, primes)) {
				primes.add(i);
			}
		}
	}

	private boolean divisibleByAny(int newNumber, Set<Integer> primes) {
		for(Integer prime: primes) {
			if(newNumber%prime==0) {
				return true;
			}
		}
		return false;
	}

	@Test
	@Ignore
	public void whenWhenIsNotEnough() {
		Set<Integer> set = spy(new LinkedHashSet<>());
		
		//when(set.add(31)).thenThrow(new RuntimeException());  -> true
		
		doThrow(new RuntimeException()).when(set).add(31); // -> false
		
		System.out.println(set.contains(31));
		
	}
}
