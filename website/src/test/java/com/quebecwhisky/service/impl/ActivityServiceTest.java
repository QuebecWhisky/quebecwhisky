package com.quebecwhisky.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.AbstractSpringDBUnitTest;
import com.quebecwhisky.service.IActivityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/testCtx.xml")
@Transactional
public class ActivityServiceTest extends AbstractSpringDBUnitTest {

	private final Resource mTestRes = new ClassPathResource(
			"com/quebecwhisky/service/impl/ActivityData.xml");

	@Autowired
	private IActivityService _activityService;

	@Override
	protected Resource getTestDataResource() {
		return mTestRes;
	}

	@Test
	public void shouldfindLimitedNumberOfNextActivities() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 20);
		
		assertThat(_activityService.getNextActivities(calendar.getTime(), 3).size(), is(2));
	}

}
