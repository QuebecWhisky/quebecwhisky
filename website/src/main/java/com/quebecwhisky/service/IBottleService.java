/**
 * 
 */
package com.quebecwhisky.service;

import java.util.List;

import com.quebecwhisky.model.Bottle;

/**
 * @author jpshields
 * 
 */
public interface IBottleService {

	Bottle findById(Long id);

	List<Bottle> getBottles();

	void persist(Bottle bottle);

	/**
	 * Returns a list of bottles that have recent reviews. The number of bottles is
	 * parameterized by bottlesCount.
	 * 
	 * @param bottlesCount Number of news.
	 * @return List of news
	 */
	List<Bottle> getRecentReviews(Integer bottlesCount);
	
}
