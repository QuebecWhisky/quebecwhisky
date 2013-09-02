/**
 * 
 */
package com.quebecwhisky.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

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

	@Inject
	private IReviewDAO _reviewDao;

}
