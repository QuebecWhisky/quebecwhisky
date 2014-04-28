package com.quebecwhisky.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.AbstractSpringDBUnitTest;
import com.quebecwhisky.model.Activity;
import com.quebecwhisky.service.IActivityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ctx/testCtx.xml")
@Transactional
public class ActivityServiceTest extends AbstractSpringDBUnitTest {

	private static final Calendar _calendar = Calendar.getInstance();
	private final Resource mTestRes = new ClassPathResource(
			"com/quebecwhisky/service/impl/ActivitySrvData.xml");

	@Inject
	private IActivityService _activityService;

	@Override
	protected Resource getTestDataResource() {
		return mTestRes;
	}

	@Test
	public void shouldfindLimitedNumberOfNextScheduledActivities() {
		_calendar.set(2013, Calendar.APRIL, 20);
		assertThat(_activityService.getNextScheduledActivities(_calendar.getTime(), 3).size(),
				is(2));
	}

	@Test
	public void shouldFindLimitedActivitiesIncludingScheduledAndTBD() {
		_calendar.set(2013, Calendar.APRIL, 20);
		List<Activity> activities = _activityService.getNextActivities(_calendar.getTime(), 3);

		assertThat(activities.size(), is(4));

		// First activities should be TBD in order of creation (desc ids)
		// Second batch is scheduled in order of date
		Activity lastActivity = null;
		for (Activity activity : activities) {

			if (lastActivity == null) {
				lastActivity = activity;
			} else {
				// TBD activities
				if (activity.getDate() == null) {
					assertThat(lastActivity.getId().compareTo(activity.getId()) < 0, is(true));
					// Scheduled activities
				} else {
					assertThat(
							lastActivity.getDate() == null
									|| !lastActivity.getDate().after(activity.getDate()), is(true));
				}
			}

		}
	}

}
