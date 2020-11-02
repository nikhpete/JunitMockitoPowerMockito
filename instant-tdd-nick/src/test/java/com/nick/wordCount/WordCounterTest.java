package com.nick.wordCount;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordCounterTest {
	
	private WordCounter counter = new WordCounter();
	
	@Test
	public void emptyStringHasNoWords(){
		counter.add("");
		assertEquals(0, counter.getUniqueWordCOunt());
	}
	
	@Test
	public void singleWordStringHasOneWords(){
		counter.add("Hello");
		assertEquals(1, counter.getUniqueWordCOunt());
	}
	
	@Test
	public void twoWordStringHasTwoWords(){
		counter.add("Hello");
		counter.add("World");
		assertEquals(2, counter.getUniqueWordCOunt());
	}

	@Test
	public void multiStringHasCorrectWords(){
		counter.add("One Two Three");
		counter.add("four five six");
		assertEquals(6, counter.getUniqueWordCOunt());
	}

	@Test
	public void spacedOutMultiStringHasCorrectWords(){
		counter.add("      One      Two       Three   ");
		assertEquals(3, counter.getUniqueWordCOunt());
	}

	@Test
	public void inputWithDuplicateCountsIndividual(){
		counter.add("One One One");
		assertEquals(1, counter.getUniqueWordCOunt());
	}

	@Test
	public void inputWithDuplicateMixedCaseCountsIndividual(){
		counter.add("One one ONE");
		assertEquals(1, counter.getUniqueWordCOunt());
	}

	@Test
	public void inputWithPunctuationStillSpotsDuplicate(){
		counter.add("One.");
		counter.add("One Two.");
		counter.add("One, Two, Three.");
		assertEquals(3, counter.getUniqueWordCOunt());
	}
}
