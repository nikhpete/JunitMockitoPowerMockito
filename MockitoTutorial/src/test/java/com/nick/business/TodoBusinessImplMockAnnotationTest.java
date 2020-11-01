package com.nick.business;


import static org.mockito.BDDMockito.*;

import java.util.*;
import  org.hamcrest.MatcherAssert;
import  org.hamcrest.CoreMatchers;
import  org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.nick.data.api.TodoService;

public class TodoBusinessImplMockAnnotationTest {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	private TodoService todoSvc;
	
	@InjectMocks
	private TodoBusinessImpl busImpl;
	
	@Captor
	private ArgumentCaptor<String> captutor;

	@Test
	public void retrieveTodosRelatedToSpring_usingMock() {
		when(todoSvc.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance"));
		List<String> filteredList = busImpl.retrieveTodosRelatedToSpring("Dummy");
		
		Assert.assertEquals(2, filteredList.size());
	}

	@Test
	public void retrieveTodosRelatedToSpring_usingBDDMock() {
		
		given(todoSvc.retrieveTodos("Dummy")).willReturn(Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance"));

		List<String> filteredList = busImpl.retrieveTodosRelatedToSpring("Dummy");
		
		MatcherAssert.assertThat(filteredList.size(), CoreMatchers.is(2));
	}

	@Test
	public void deleteTodosNotRelatedToSpring() {
		
		when(todoSvc.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance"));

		busImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		verify(todoSvc, times(1)).deleteTodo("Learn to Dance");
		verify(todoSvc, atLeast(1)).deleteTodo("Learn to Dance");
		verify(todoSvc, never()).deleteTodo("Learn Spring MVC");
	}

	@Test
	public void deleteTodosNotRelatedToSpring_usingBDDMock() {
		
		given(todoSvc.retrieveTodos("Dummy")).willReturn(Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance"));

		busImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		then(todoSvc).should(times(1)).deleteTodo("Learn to Dance");
		then(todoSvc).should(atLeast(1)).deleteTodo("Learn to Dance");
		then(todoSvc).should(never()).deleteTodo("Learn Spring MVC");
		
		then(todoSvc).should(times(1)).deleteTodo(captutor.capture());
		MatcherAssert.assertThat(captutor.getValue(), CoreMatchers.is("Learn to Dance"));
	}

	@Test
	public void deleteTodosNotRelatedToSpring_usingBDDMockCaptureMultipleValues() {
		
		ArgumentCaptor<String> captutor = ArgumentCaptor.forClass(String.class);
		
		given(todoSvc.retrieveTodos("Dummy")).willReturn(Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance", "Ready to Rcok and Roll"));

		busImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		then(todoSvc).should(times(2)).deleteTodo(captutor.capture());
		MatcherAssert.assertThat(captutor.getAllValues().size(), CoreMatchers.is(2));
	}

}
