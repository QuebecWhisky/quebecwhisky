/**
 * 
 */
package com.quebecwhisky.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

	@Inject
	private IBottleDAO _bottleDao;

	@Override
	public Bottle findById(Long id) {
		return _bottleDao.findOne(id);
	}

	@Override
	public List<Bottle> getBottles() {
		return _bottleDao.findAll();
	}

	@Override
	public List<Bottle> getRecentReviews(Integer bottlesCount) {
		return this._bottleDao.getRecentReviews(bottlesCount);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void persist(Bottle bottle) {
		_bottleDao.persist(bottle);
	}

}
