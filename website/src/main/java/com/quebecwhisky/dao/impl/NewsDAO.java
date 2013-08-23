/**
 * 
 */
package com.quebecwhisky.dao.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.quebecwhisky.dao.INewsDAO;
import com.quebecwhisky.model.News;
import com.quebecwhisky.model.News_;

/**
 * @author jpshields
 * 
 */
@Named
public class NewsDAO extends AbstractHibernateDAO<News> implements INewsDAO {

	public NewsDAO() {
		super(News.class);
	}

	@Override
	public List<News> getRecentNews(Integer newsNumber) {
		CriteriaQuery<News> criteria = criteriaQuery();
		Root<News> root = criteria.from(News.class);
		Path<Date> date = root.get(News_.created);
		criteria.select(root);
		criteria.orderBy(criteriaBuilder().asc(date));
		return getEntityManager().createQuery(criteria)
				.setMaxResults(newsNumber).getResultList();
	}

}
