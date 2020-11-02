package com.nick.articleDistribution.sender;

import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nick.articleDistribution.article.Article;
import com.nick.articleDistribution.article.Type;
import com.nick.articleDistribution.client.*;
import com.nick.articleDistribution.database.ArticleDataAccess;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {
	
	@Mock
	private SportsChannel sport;
	
	@Mock
	private EntertainmentChannel entertainment;
	
	@Mock
	private OtherChannel other;

	@Mock
	private ArticleDataAccess dataAccess;

	@InjectMocks
	private ArticleDistributor distributor;

	@Test
	public void sportsGoesToSportPoliticsToOther() {
		List<Article> list = Arrays.asList( new Article("Sport is fun", Type.SPORT), new Article("Politics is bad", Type.POLITICS));
		when(dataAccess.getTodaysArticles()).thenReturn(list);

		distributor.distributeTodays();

		verify(sport).accept(any());
		verify(other).accept(any());
		verify(entertainment, never()).accept(any());
	}

}
