/**
 * 
 */
package com.quebecwhisky.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.dao.IActivityDAO;
import com.quebecwhisky.model.Activity;
import com.quebecwhisky.service.IActivityService;

/**
 * @author jpshields
 * 
 */
@Named
@Transactional(readOnly = true)
public class ActivityServiceImpl implements IActivityService {

	@Inject
	private IActivityDAO _activityDao;

	@Override
	public Activity getNextScheduledActivity(Date from) {
		Activity activity = null;
		List<Activity> activities = getNextScheduledActivities(from, 1);
		if (!activities.isEmpty()) {
			activity = activities.get(0);
		}
		return activity;
	}

	@Override
	public List<Activity> getNextScheduledActivities(Date from, Integer activitiesNumber) {
		return _activityDao.getNextScheduledActivities(from, activitiesNumber);
	}

	@Override
	public List<Activity> getNextActivities(Date from, Integer activitiesNumber) {
		List<Activity> activityList = new LinkedList<Activity>();
		activityList.addAll(_activityDao.getTBDActivities());
		activityList.addAll(this.getNextScheduledActivities(from, activitiesNumber));
		return activityList;
	}

	@Override
	@Transactional(readOnly = false)
	public void persist(Activity activity) {
		_activityDao.persist(activity);
	}

}
