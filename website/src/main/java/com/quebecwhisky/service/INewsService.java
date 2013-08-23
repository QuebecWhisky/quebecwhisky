/**
 * 
 */
package com.quebecwhisky.service;

import java.util.List;

import com.quebecwhisky.model.News;

/**
 * @author jpshields
 * 
 */
public interface INewsService {

	/**
	 * Returns a list of news. the number of news is parameterized by newsNumber.
	 * 
	 * @param newsNumber Number of news.
	 * @return List of news
	 */
	List<News> getRecentNews(Integer newsNumber);

}
