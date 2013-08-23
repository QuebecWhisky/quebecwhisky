/**
 * 
 */
package com.quebecwhisky.dao.impl;

import javax.inject.Named;

import com.quebecwhisky.dao.IReviewDAO;
import com.quebecwhisky.model.Review;

/**
 * @author jpshields
 * 
 */
@Named
public class ReviewDAO extends AbstractHibernateDAO<Review> implements
		IReviewDAO {

	public ReviewDAO() {
		super(Review.class);
	}

}
