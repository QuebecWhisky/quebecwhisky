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

}
