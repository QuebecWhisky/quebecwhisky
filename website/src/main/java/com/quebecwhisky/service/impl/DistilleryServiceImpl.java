/**
 * 
 */
package com.quebecwhisky.service.impl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.dao.IDistilleryDAO;
import com.quebecwhisky.service.IDistilleryService;

/**
 * @author jpshields
 * 
 */
@Named
@Transactional(readOnly = true)
public class DistilleryServiceImpl implements IDistilleryService {

	@Autowired
	private IDistilleryDAO _distilleryDao;

}
