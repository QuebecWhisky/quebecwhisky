/**
 * 
 */
package com.quebecwhisky.dao;

import java.util.List;

import com.quebecwhisky.model.Bottle;

/**
 * @author jpshields
 * 
 */
public interface IBottleDAO extends IBaseHibernateDAO<Bottle> {

	/**
	 * Returns a list of Bottles that have recent reviews. The number of bottles
	 * is parameterized by bottlesCount.
	 * 
	 * @param bottlesCount
	 *            Number of bottles.
	 * @return List of bottles
	 */
	List<Bottle> getRecentReviews(Integer bottlesCount);

}
