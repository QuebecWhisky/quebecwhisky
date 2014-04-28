package com.quebecwhisky.dao.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.AbstractSpringDBUnitTest;
import com.quebecwhisky.dao.IActivityDAO;
import com.quebecwhisky.model.Activity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/testCtx.xml")
@Transactional
public class ActivityDAOTest extends AbstractSpringDBUnitTest {

	private static final Calendar _calendar = Calendar.getInstance();
	private final Resource mTestRes = new ClassPathResource(
			"com/quebecwhisky/dao/impl/ActivityDAOData.xml");

	@Autowired
	private IActivityDAO mDAO;

	@Override
	protected Resource getTestDataResource() {
		return mTestRes;
	}

	@Test
	public void shouldFindTotalAmount() {
		assertThat(mDAO.findAll().size(), is(5));
	}

	@Test
	public void shouldFindOrderedDatedActivitiesFutureToASpecificDate() {

		_calendar.set(2014, 1, 1); // 1er février
		List<Activity> activityList = mDAO.getNextScheduledActivities(_calendar.getTime(),
				Integer.valueOf(5));

		// Vérifier la quantité
		assertThat(activityList.size(), is(2));

		// Vérifier que l'ordre des activités à venir est respecté
		Date lastActivityDate = null;
		for (Activity activity : activityList) {
			Date upcomingActivityDate = activity.getDate();
			if (lastActivityDate == null) {
				lastActivityDate = upcomingActivityDate;
			} else {
				assertThat(!lastActivityDate.after(upcomingActivityDate), is(true));
				lastActivityDate = upcomingActivityDate;
			}
		}
	}

	@Test
	public void shouldFindOrderedTBDActivities() {

		List<Activity> activityList = mDAO.getTBDActivities();

		// Vérifier la quantité
		assertThat(activityList.size(), is(2));

		// Vérifier que l'ordre des activités à venir est respecté
		Long lastActivityId = null;
		for (Activity activity : activityList) {
			Long newActivityId = activity.getId();
			if (lastActivityId == null) {
				lastActivityId = newActivityId;
			} else {
				assertThat(lastActivityId.compareTo(newActivityId) < 0, is(true));
				lastActivityId = newActivityId;
			}
		}
	}

}
