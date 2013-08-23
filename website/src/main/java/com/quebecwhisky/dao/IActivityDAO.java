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
	 * Returns a list of future activities. The number of activities is
	 * parametrized by activitiesNumber.
	 * 
	 * @param from Date from which to select the activities.
	 * @param activitiesNumber Number of activities.
	 * @return A list of future activities.
	 */
	List<Activity> getNextActivities(Date from, Integer activitiesNumber);

}
