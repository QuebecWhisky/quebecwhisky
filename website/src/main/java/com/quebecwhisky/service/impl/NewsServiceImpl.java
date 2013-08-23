/**
 * 
 */
package com.quebecwhisky.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.dao.INewsDAO;
import com.quebecwhisky.model.News;
import com.quebecwhisky.service.INewsService;

/**
 * @author jpshields
 * 
 */
@Named
@Transactional(readOnly = true)
public class NewsServiceImpl implements INewsService {

	@Autowired
	private INewsDAO _newsDao;

	@Override
	public List<News> getRecentNews(Integer newsNumber) {
		return this._newsDao.getRecentNews(newsNumber);
	}

}
