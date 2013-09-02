/**
 * 
 */
package com.quebecwhisky.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.service.IBottleService;
import com.quebecwhisky.service.IDistilleryService;
import com.quebecwhisky.service.IReviewService;
import com.quebecwhisky.service.ISearchService;

/**
 * @author jpshields
 * 
 */
@Named
@Transactional(readOnly = true)
public class SearchServiceImpl implements ISearchService {

	@Inject
	private IDistilleryService _distillerySrv;

	@Inject
	private IBottleService _bottleSrv;

	@Inject
	private IReviewService _reviewSrv;

}
