/**
 * 
 */
package com.quebecwhisky.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.dao.IBottleDAO;
import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.service.IBottleService;

/**
 * @author jpshields
 *
 */
@Named
@Transactional(readOnly = true)
public class BottleServiceImpl implements IBottleService {

	@Autowired
	private IBottleDAO _bottleDao;
	
	public List<Bottle> getBottles() {
		return _bottleDao.findAll();
	}

}
