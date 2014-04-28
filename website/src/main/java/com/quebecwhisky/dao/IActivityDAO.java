/**
 * 
 */
package com.quebecwhisky.dao;

import java.util.Date;
import java.util.List;

import com.quebecwhisky.model.Activity;

/**
 * @author jpshields
 * 
 */
public interface IActivityDAO extends IBaseHibernateDAO<Activity> {

	/**
	 * Returns a list of future activities that have a scheduled date. The
	 * number of activities is parameterized by activitiesNumber.
	 * 
	 * @param from
	 *            date from which to select the activities.
	 * @param activitiesNumber
	 *            Number of activities.
	 * @return A list of future activities.
	 */
	List<Activity> getNextScheduledActivities(Date from, Integer activitiesNumber);

	/**
	 * Returns a list of to be determined activities. The list will be ordered
	 * by ids.
	 * 
	 * @return A list of activities
	 */
	List<Activity> getTBDActivities();

}
