package com.nick.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.nick.data.api.TodoService;
import com.nick.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void retrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoSvc = new TodoServiceStub();
		TodoBusinessImpl busImpl = new TodoBusinessImpl(todoSvc);
		List<String> filteredList = busImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredList.size());
	}

}
