package com.nick.mockitoRetrunValues;

import java.io.IOException;
import java.util.List;

public interface SomeInterface {
	int getMatchingSize(int x, int  y);

	void reciveList(List<String> list);

	boolean isFileValid(String anyString) throws IOException;
}
