package com.nick.articleDistribution.article;

public class Article {

	private String content;
	private Type type;
	public Article(String content, Type type) {
		super();
		this.content = content;
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	
	public Type getType() {
		return type;
	}
}
