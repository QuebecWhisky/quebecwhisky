/**
 * 
 */
package com.quebecwhisky.dao.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.quebecwhisky.dao.IBottleDAO;
import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.model.Bottle_;
import com.quebecwhisky.model.Review;
import com.quebecwhisky.model.Review_;

/**
 * @author jpshields
 * 
 */
@Named
public class BottleDAO extends AbstractHibernateDAO<Bottle> implements
		IBottleDAO {

	public BottleDAO() {
		super(Bottle.class);
	}

	@Override
	public List<Bottle> getRecentReviews(Integer bottlesCount) {
		CriteriaQuery<Bottle> criteria = criteriaQuery();
		Root<Bottle> bottles = criteria.from(Bottle.class);

		// Cast pour éviter des problèmes avec les bds de tests (HSQL ou H2)
		// Si je fais le join et le fetch après, ça ne fonctionne pas.
		@SuppressWarnings("unchecked")
		Join<Bottle, Review> reviews = (Join<Bottle, Review>) bottles
				.fetch(Bottle_.reviews);
		Path<Date> reviewCreation = reviews.get(Review_.created);

		criteria.select(bottles).distinct(true);
		criteria.orderBy(criteriaBuilder().desc(reviewCreation));

		return getEntityManager().createQuery(criteria)
				.setMaxResults(bottlesCount).getResultList();
	}

}
