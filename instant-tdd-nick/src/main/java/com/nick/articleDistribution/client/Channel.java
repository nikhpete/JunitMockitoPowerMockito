package com.nick.articleDistribution.client;

import com.nick.articleDistribution.article.Article;

public interface Channel {
	
	void accept(Article article);

}
