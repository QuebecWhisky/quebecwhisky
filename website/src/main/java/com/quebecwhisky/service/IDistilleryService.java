/**
 * 
 */
package com.quebecwhisky.service;

import java.util.List;

import com.quebecwhisky.model.Distillery;

/**
 * @author jpshields
 * 
 */
public interface IDistilleryService {

	Distillery findById(Long id);
	
	List<Distillery> getDistilleries();

	void persist(Distillery distillery);

}
