/**
 * 
 */
package com.quebecwhisky.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.dao.IDistilleryDAO;
import com.quebecwhisky.model.Distillery;
import com.quebecwhisky.service.IDistilleryService;

/**
 * @author jpshields
 * 
 */
@Named
@Transactional(readOnly = true)
public class DistilleryServiceImpl implements IDistilleryService {

	@Inject
	private IDistilleryDAO _distilleryDao;

	@Override
	@Transactional(readOnly = false)
	public void persist(Distillery distillery) {
		_distilleryDao.persist(distillery);
	}

}
