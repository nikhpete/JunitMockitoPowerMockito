package com.nick.articleDistribution.sender;

import java.util.List;

import com.nick.articleDistribution.article.Article;
import com.nick.articleDistribution.client.*;
import com.nick.articleDistribution.database.ArticleDataAccess;

public class ArticleDistributor {

	private Channel sport;
	private Channel entertainment;
	private Channel other;
	private ArticleDataAccess dataAccess;

	public ArticleDistributor(SportsChannel sport, EntertainmentChannel entertainment, OtherChannel other, ArticleDataAccess dataAccess) {
		this.sport = sport;
		this.entertainment = entertainment;
		this.other = other;
		this.dataAccess = dataAccess;
	}

	public void distributeTodays() {
		for (Article a : dataAccess.getTodaysArticles()) {
			switch (a.getType()) {
			case SPORT:
				sport.accept(a);
				break;
			case ENTERTAINMENT:
				entertainment.accept(a);
				break;
			default:
				other.accept(a);
			}
		}
	}

}
