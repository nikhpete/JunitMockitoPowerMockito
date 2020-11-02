package com.nick.wordCount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {
	
	Set<String> wordsSoFar = new HashSet<>();

	public void add(String sentence) {
		if(sentence.isEmpty()) return;
		wordsSoFar
			.addAll(
				new HashSet<>(
					Arrays.asList(sentence.trim().split("[., ]+"))
					.stream()
					.map(val-> val.toLowerCase())
					.collect(Collectors.toList())
				)
			);
	}

	public int getUniqueWordCOunt() {
		return wordsSoFar.size();
	}

}
