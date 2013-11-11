package com.quebecwhisky.dao.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.AbstractSpringDBUnitTest;
import com.quebecwhisky.dao.IBottleDAO;
import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.model.Review;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/testCtx.xml")
@Transactional
public class BottleDAOTest extends AbstractSpringDBUnitTest {

	private final Resource mTestRes = new ClassPathResource(
			"com/quebecwhisky/dao/impl/BottleDAOData.xml");

	@Autowired
	private IBottleDAO mDAO;

	@Override
	protected Resource getTestDataResource() {
		return mTestRes;
	}

	@Test
	public void find() {
		assertThat(mDAO.findAll().size(), is(10));
	}

	@Test
	public void shouldFindBottleWithMostRecentReviews() {
		
		Integer bottleCount = Integer.valueOf(5);
		List<Bottle> bottleList = mDAO.getRecentReviews(bottleCount);
		
		// Vérifier la quantité
		assertThat(bottleList.size(), is(bottleCount));
		
		// Vérifier que l'ordre des critiques récentes est respecté pour les bouteilles
		Date lastRecentReview = null;
		for (Bottle bottle : bottleList) {
		
			// Date de la plus récente critique de la bouteille
			Date bottleMostRecentReview = null;
			for (Review review : bottle.getReviews()) {
				if (bottleMostRecentReview == null) {
					bottleMostRecentReview = review.getCreated();
				}
				else if (review.getCreated().after(bottleMostRecentReview))
				{
					bottleMostRecentReview = review.getCreated();
				}
			}
			
			if (lastRecentReview == null) {
				lastRecentReview = bottleMostRecentReview;
			}
			
			assertThat(!lastRecentReview.before(bottleMostRecentReview), is(true));
			
			lastRecentReview = bottleMostRecentReview;
		}
	}
	
}
