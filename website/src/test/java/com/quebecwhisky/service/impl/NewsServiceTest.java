package com.quebecwhisky.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.AbstractSpringDBUnitTest;
import com.quebecwhisky.service.INewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/testCtx.xml")
@Transactional
public class NewsServiceTest extends AbstractSpringDBUnitTest {

	private final Resource mTestRes = new ClassPathResource(
			"com/quebecwhisky/service/impl/NewsData.xml");

	@Autowired
	private INewsService _newsService;

	@Override
	protected Resource getTestDataResource() {
		return mTestRes;
	}

	@Test
	public void shouldfindLimitedNumberOfRecentNews() {
		assertThat(_newsService.getRecentNews(2).size(), is(2));
	}

}
