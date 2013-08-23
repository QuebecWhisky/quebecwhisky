/**
 * 
 */
package com.quebecwhisky.service.impl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.dao.IReviewDAO;
import com.quebecwhisky.service.IReviewService;

/**
 * @author jpshields
 * 
 */
@Named
@Transactional(readOnly = true)
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private IReviewDAO _reviewDao;

}
