package com.nick.exception;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExemptionTest {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test //(expected = IOException.class)
	public void willThrowThrows() throws Exception {
		expected.expect(IOException.class);
		
		willThrow();
	}

	private void willThrow() throws IOException{
		throw new IOException("Bang");
	}
}
