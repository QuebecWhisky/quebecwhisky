/**
 * 
 */
package com.quebecwhisky.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

	@Inject
	private INewsDAO _newsDao;

	@Override
	public List<News> getRecentNews(Integer newsNumber) {
		return this._newsDao.getRecentNews(newsNumber);
	}

}
