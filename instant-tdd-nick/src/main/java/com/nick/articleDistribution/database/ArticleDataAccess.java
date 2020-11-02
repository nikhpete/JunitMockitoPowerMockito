package com.nick.articleDistribution.database;

import java.util.List;

import com.nick.articleDistribution.article.Article;

public interface ArticleDataAccess {

	List<Article> getTodaysArticles();
}
