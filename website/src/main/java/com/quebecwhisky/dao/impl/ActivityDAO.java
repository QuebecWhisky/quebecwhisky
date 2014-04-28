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

import com.quebecwhisky.dao.IActivityDAO;
import com.quebecwhisky.model.Activity;
import com.quebecwhisky.model.Activity_;

/**
 * @author jpshields
 * 
 */
@Named
public class ActivityDAO extends AbstractHibernateDAO<Activity> implements IActivityDAO {

	public ActivityDAO() {
		super(Activity.class);
	}

	@Override
	public List<Activity> getNextScheduledActivities(Date from, Integer activitiesNumber) {
		CriteriaQuery<Activity> criteria = criteriaQuery();
		Root<Activity> root = criteria.from(Activity.class);
		Path<Date> date = root.get(Activity_.date);
		criteria.select(root);
		criteria.where(criteriaBuilder().greaterThanOrEqualTo(date, from));
		criteria.orderBy(criteriaBuilder().asc(date));
		return getEntityManager().createQuery(criteria).setMaxResults(activitiesNumber)
				.getResultList();
	}

	@Override
	public List<Activity> getTBDActivities() {
		CriteriaQuery<Activity> criteria = criteriaQuery();
		Root<Activity> root = criteria.from(Activity.class);
		Path<Date> date = root.get(Activity_.date);
		criteria.select(root);
		criteria.where(criteriaBuilder().isNull(date));
		Path<Long> id = root.get(Activity_.id);
		criteria.orderBy(criteriaBuilder().asc(id));
		return getEntityManager().createQuery(criteria).getResultList();
	}

}
