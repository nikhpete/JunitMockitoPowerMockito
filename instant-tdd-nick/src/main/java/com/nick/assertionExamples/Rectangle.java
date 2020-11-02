package com.nick.assertionExamples;

import java.util.*;

public class Rectangle {

	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public double aspectRatio() {
		return (double) width/height;
	} 

	public boolean isSquare() {
		return height == width;
	}
	
	public int getArea() {
		return width * height;
	}
	
	public int[] getSides() {
		return new int [] {width, height};
	}
	
	public List<Integer> getSideList() {
		return Arrays.asList(width, height);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			return width == ((Rectangle) obj).width && height == ((Rectangle) obj).height;
		}
		return false;
	}
	
	

}
