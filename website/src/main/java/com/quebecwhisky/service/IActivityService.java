/**
 * 
 */
package com.quebecwhisky.service;

import java.util.Date;
import java.util.List;

import com.quebecwhisky.model.Activity;

/**
 * @author jpshields
 * 
 */
public interface IActivityService {

	/**
	 * Returns the next activity.
	 * 
	 * @param from
	 *            Date from which to select the activities.
	 * @return an activity
	 */
	Activity getNextScheduledActivity(Date from);

	/**
	 * Returns a list of future activities. The number of activities is
	 * parameterized by activitiesNumber.
	 * 
	 * @param from
	 *            Date from which to select the activities.
	 * @param activitiesNumber
	 *            Number of activities.
	 * @return A list of future activities.
	 */
	List<Activity> getNextScheduledActivities(Date from, Integer activitiesNumber);

	/**
	 * Returns a list of future activities (scheduled an unscheduled). Scheduled
	 * activities will be limited in time by the from parameter. All TBD
	 * activities will be added to the front of the list in a descendant order
	 * of creation. The number of activities is parameterized by
	 * activitiesNumber.
	 * 
	 * @param from
	 *            Date from which to select the activities.
	 * @param activitiesNumber
	 *            Number of activities.
	 * @return A list of future activities.
	 */
	List<Activity> getNextActivities(Date from, Integer activitiesNumber);

	void persist(Activity activity);

}
