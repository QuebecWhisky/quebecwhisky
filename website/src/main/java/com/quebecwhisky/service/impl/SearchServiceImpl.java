/**
 * 
 */
package com.quebecwhisky.service.impl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private IDistilleryService _distillerySrv;

	@Autowired
	private IBottleService _bottleSrv;

	@Autowired
	private IReviewService _reviewSrv;

}
